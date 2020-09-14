package example11_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student2 implements Comparable{
    String name;
    int ban;
    int no;
    int kor, eng, math;

    int total;
    int schoolRank;
    int classRank;

    Student2(String name, int ban, int no, int kor, int eng, int math){
        this.name=name;
        this.ban=ban;
        this.no=no;
        this.kor=kor;
        this.eng=eng;
        this.math=math;

        total = kor+math+eng;
    }

    int getTotal(){
        return total;
    }

    float getAverage(){
        return (int)((getTotal()/3f)*10+0.5)/10f;
    }

    public String toString(){
        return name +","+ban+","+no+","+kor+","+eng+","+math+","
                +getTotal()+","+getAverage()+","+schoolRank+","+classRank;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student2) {
            Student2 tmp = (Student2) o;
            return tmp.total - this.total;
        }
        return -1;
    }
}

public class Ex11_8 {
    public static void calculateSchoolRank(List list){
        Collections.sort(list); // 내림차순; 큰거부터

        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();

        for(int i=0; i<length; i++){
            if(list.get(i) instanceof Student2){
                if(((Student2) list.get(i)).total==prevTotal){
                    ((Student2) list.get(i)).schoolRank = prevRank;
                }else{
                    ((Student2) list.get(i)).schoolRank = i+1;
                }
                prevTotal = ((Student2) list.get(i)).total;
                prevRank = ((Student2) list.get(i)).schoolRank;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student2("홍길동",1,3,100,100,100));
        list.add(new Student2("남궁성",1,1,90,70,80));
        list.add(new Student2("김자바",1,2,80,80,90));
        list.add(new Student2("이자바",2,1,70,90,70));
        list.add(new Student2("안자바",2,2,60,100,80));

        calculateSchoolRank(list);
        Iterator it = list.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}
