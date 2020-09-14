package example11_12;

import java.util.*;

class ClassTotalComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Student2 && o2 instanceof Student2){
            Student2 s1 = (Student2)o1;
            Student2 s2 = (Student2)o2;

            int result = s1.ban-s2.ban; // 반 오름차순
            if(result==0){
                result = s2.total-s1.total; // 총점 내림차순
            }
            return result;
        }
        return -1;
    }
}

public class Ex11_9 {
    public static void calculateClassRank(List list){
        Collections.sort(list, new ClassTotalComparator());

        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();


        for(int i=0,rank = 0; i<length; i++, rank++){
            Student2 s = (Student2)list.get(i);
            if(s.ban!=prevBan){
                prevRank=-1;
                prevTotal=-1;
                rank=0;
            }
            if(s.total==prevTotal)
                s.classRank=prevRank;
            else{
                s.classRank=rank+1;
            }
            prevBan=s.ban;
            prevRank=s.classRank;
            prevTotal=s.total;
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
        calculateClassRank(list);
        Iterator it = list.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
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
}
