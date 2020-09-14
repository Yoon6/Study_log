package ch11;

import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1), "2" ,"2","4","3"};
        Set set = new HashSet();

        for(int i=0; i<6; i++){
            set.add((int)(Math.random()*45)+1);
        }
        List list = new LinkedList(set); // set은 Collections의 sort를 사용할 수 없다.

        Collections.sort(list);
        System.out.println(list);
    }
}
