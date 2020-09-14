package ch9;
import java.util.regex.*;

public class RegularEx4 {
    public static void main(String[] args) {
        String source = "A broken hand works, but not a broken heart.";
        String pattern = "broken";
        StringBuffer sb = new StringBuffer();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        System.out.println("source:"+source);

        int i=0;

        while(m.find()){
            System.out.println(++i+"번째 매칭:"+m.start()+"~"+m.end());
            m.appendReplacement(sb, "drunken");// sb에 source의 시작부터 타겟위치까지 내용에 drunken을 더해서 저장
        }

        m.appendTail(sb); // sb에 뒷부분도 저장
        System.out.println("Replacement count : "+i);
        System.out.println("result : "+sb.toString());
    }
}
