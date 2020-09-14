package ch9;

public class StringBufferEx1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        // StringBuffer클래스는 equals메소드를 오버라이딩하지 않았기 때문에 ==연산자와 동일한 결과이다.
        System.out.println("sb == sb2 ? "+(sb == sb2));
        System.out.println("sb.equals(sb2) ? "+(sb.equals(sb2)));

        // String에 담아서 equals메소드로 비교하면 된다.
        String s = sb.toString();
        String s2 = sb2.toString();

        System.out.println("s.equals(s2) ? "+(s.equals(s2)));
    }
}
