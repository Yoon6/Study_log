package ch14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx7 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true, 1, 1,300),
                new Student2("김지미", false, 1, 1,250),
                new Student2("김자바", true, 1, 2,200),
                new Student2("이지미", false, 1, 2,150),
                new Student2("남자바", true, 1, 2,100),
                new Student2("안지미", false, 1, 2,50),
                new Student2("황지미", false, 1, 3,100),
                new Student2("강지미", false, 1, 3,150),
                new Student2("이자바", true, 1, 3,200),

                new Student2("나자바", true, 2, 1,300),
                new Student2("김지미", false, 2, 1,250),
                new Student2("김자바", true, 2, 2,200),
                new Student2("이지미", false, 2, 2,150),
                new Student2("남자바", true, 2, 2,100),
                new Student2("안지미", false, 2, 2,50),
                new Student2("황지미", false, 2, 3,100),
                new Student2("강지미", false, 2, 3,150),
                new Student2("이자바", true, 2, 3,200)
        };

        System.out.printf("1. 단순분할(성별)%n");
        Map<Boolean, List<Student2>> stuByGender = Stream.of(stuArr).collect(
                partitioningBy(Student2::isMale)
        );
        List<Student2> maleStudent = stuByGender.get(true);
        List<Student2> femaleStudent = stuByGender.get(false);

        for(Student2 s:maleStudent) System.out.println(s);
        for(Student2 s:femaleStudent) System.out.println(s);

        System.out.printf("%n2 단순분할 + 통계(성별, 학생수)%n");
        Map<Boolean, Long> stuNumByGender = Stream.of(stuArr).collect(
                partitioningBy(Student2::isMale, counting())
        );
        System.out.println("남학생 수:"+stuNumByGender.get(true));
        System.out.println("여학생 수:"+stuNumByGender.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별, 1등)%n");
        Map<Boolean, Optional<Student2>> topScoreByGender = Stream.of(stuArr).collect(
                partitioningBy(Student2::isMale, maxBy(comparingInt(Student2::getTotalScore)))
        );
        System.out.println("남학생 1등:"+topScoreByGender.get(true));
        System.out.println("여학생 1등:"+topScoreByGender.get(false));

        Map<Boolean, Student2> topScoreByGender2 = Stream.of(stuArr).collect(
                partitioningBy(Student2::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student2::getTotalScore)), Optional::get
                        ))
        );
        System.out.println("남학생 1등:"+topScoreByGender2.get(true));
        System.out.println("여학생 1등:"+topScoreByGender2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuByGender =
                Stream.of(stuArr).collect(
                        partitioningBy(Student2::isMale,
                                partitioningBy(s->s.getTotalScore()<=100))
                );
        List<Student2> failedMaleStu = failedStuByGender.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuByGender.get(false).get(true);

        for(Student2 s : failedMaleStu) System.out.println(s);
        for(Student2 s : failedFemaleStu) System.out.println(s);
    }
}
class Student2 implements Comparable<Student>{
    String name;
    boolean isMale;
    int hak;
    int ban;
    int totalScore;
    Student2(String name, boolean isMale, int hak, int ban, int totalScore){
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.totalScore = totalScore;
    }
    public String toString(){
        return String.format("[%s, %s, %d학년 %d반 %3d점]", name, isMale?"남":"여", hak, ban, totalScore);
    }

    public int getBan() { return ban; }
    public int getTotalScore() { return totalScore; }
    public String getName() { return name; }
    public boolean isMale() { return isMale; }
    public int getHak() { return hak; }

    public int compareTo(Student student){
        return student.totalScore - this.totalScore;
    }
    //groupingBy()에서 사용
    enum Level{HIGH, MID, LOW}
}