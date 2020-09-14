package ch9;

import java.util.StringJoiner;

public class StringEx4 {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");

        System.out.println(String.join("-",arr));

        // 구분자, 접두사, 접미사
        StringJoiner sj = new StringJoiner("/","[","]");
        for(String s:arr) // 향상된 for문
            sj.add(s); // StringJoiner에 추가하기

        System.out.println(sj.toString()); // toString으로 출력
    }
}
