package ch9;

public class StringEx7 {
    public static void main(String[] args) {
        String fullName = "Hello.java";

        //.의 위치 반환
        int index = fullName.indexOf('.');

        // substring 문자열 추출
        String fileName = fullName.substring(0, index);

        // index+1부터
        String ext = fullName.substring(index+1);

        System.out.println(fullName+"의 확장자를 제외한 이름은 "+fileName);
        System.out.println(fullName+"의 확장자는 ".trim()+ext);
    }
}
