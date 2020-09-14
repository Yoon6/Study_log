package ch9;

public class StringEx1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        System.out.println("String str1 = \"abc\";");
        System.out.println("String str2 = \"abc\";");

        // 리터럴은 주소가 같다. 1,2는 같은 객체를 참조한다.
        System.out.println("str1 == str2 ?"+(str1 == str2));
        System.out.println("str1.equals(str2) ?"+str1.equals(str2));
        System.out.println();

        String str3 = new String("abc");
        String str4 = new String("abc");

        //생성자를 이용하면 새로운 인스턴스를 만든다.
        System.out.println("String str3 = new String(\"abc\");");
        System.out.println("String str4 = new String(\"abc\");");

        System.out.println("str3 == str4 ?"+(str3 == str4));
        System.out.println("str3.equals(str4) ?"+str3.equals(str4));

    }
}
