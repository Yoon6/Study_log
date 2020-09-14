package ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {
    public static void main(String[] args) {
        String source = "HP:011-1111-1111, HOME:02-999-9999";
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        int i = 0;
        while(m.find()){ // find()는 주어진 소스내에 패턴과 일치하는 부분을 탐색 없으면 false;
            System.out.println(++i+": "+m.group()+"-> "+m.group(1)+", "+m.group(2)+", "+m.group(3)); //패턴을 - 로 나눴기 때문에 group 123에 각각 저장되고, group() group(0)은 전체를 나타낸다.
       }
    }
}
