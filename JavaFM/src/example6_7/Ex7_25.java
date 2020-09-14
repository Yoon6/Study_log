package example6_7;

class Outer{
    class Inner{
        int iv = 100;
    }
}

public class Ex7_25 {
    public static void main(String[] args) {
        Outer.Inner OI = new Outer().new Inner();
        System.out.println(OI.iv);
    }
}
