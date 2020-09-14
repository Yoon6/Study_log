package ch8;

public class ExceptionEx9 {
    public static void main(String[] args) {
        try {
            throw new Exception("고의 예외");
        }catch (Exception e){
            System.out.println("에러메세지 : "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");
    }
}
