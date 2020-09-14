package ch9;

public class StringBufferEx2 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("01");
        StringBuffer sb2 = sb.append(23);
        sb.append('4').append(56);

        StringBuffer sb3 = sb.append(78);
        sb3.append(9.0);

        //sb를 참조하기 때문에 모두 같음
        System.out.println("sb = "+sb); //0123456789.0
        System.out.println("sb2 = "+sb2); //0123456789.0
        System.out.println("sb3 = "+sb3); //0123456789.0


        System.out.println("sb = "+sb.deleteCharAt(10)); // 012345678
        System.out.println("sb = "+sb.delete(3, 6)); // 012678
        System.out.println("sb = "+sb.insert(3, "abc")); //012abc678
        System.out.println("sb = "+sb.replace(6, sb.length(), "END")); //012abcEND

        System.out.println("capacity="+sb.capacity()); // 버퍼 크기
        System.out.println("length="+sb.length()); // 문자열 길이

    }
}
