package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
    public static void main(String[] args) {
        Student[] sArr = {
                new Student(100,"aaa"),
                new Student(300,"bbb"),
                new Student(400,"ccc"),
                new Student(200,"ddd"),
        };

        Arrays.sort(sArr);
        System.out.println(Arrays.toString(sArr));
        Arrays.sort(sArr, new NameAscending());
        System.out.println(Arrays.toString(sArr));
    }
}

class NameAscending implements Comparator{
    public int compare(Object o1, Object o2){
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;

        return  s1.name.compareTo(s2.name);
    }
}

class Student implements Comparable{
    int score;
    String name;

    Student(int score, String name){
        this.score = score;
        this.name = name;
    }

    public String toString(){
        return score+","+name;
    }
    public int compareTo(Object obj){
        Student s2 = (Student)obj;

        //return s2.score - this.score;
        return this.score - s2.score;
    }
}