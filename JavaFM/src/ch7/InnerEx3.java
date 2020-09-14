package ch7;

public class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner{
        int iiv = outerIv; // 외부 클래스의 private멤버에도 접근 가능.
        int iiv2 = outerCv;
    }
    static class StaticInner{
        // 스태틱 클래스는 외부클래스의 인스턴스 멤버에 접근할 수 없다.
        //int siv = outerIv;
        static int scv = outerCv;
    }
    void myMethod(){
        int lv = 0;
        final int LV = 0;
        // JDK1.8부터 final생략가능, 컴파일러에서 붙여줌
        class LocalInner{
            int liv = outerIv;
            int liv2 = outerCv;
            // 외부클래스의 지역변수는 final이 붙은 상수만 접근가능함.
            // JDK1.8 부터는 컴파일러가 자동으로 붙여주기 때문에 생략가능
            int liv3 = lv;
            int liv4 = LV;
        }
    }
}
