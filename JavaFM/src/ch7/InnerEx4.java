package ch7;

class Outer{
    class InstanceInenr{
        int iv = 100;
    }
    static class StaticInner{
        int iv = 200;
        static int cv = 300;
    }
    void myMethod(){
        class LocalInner{
            int iv = 400;
        }
    }
}

public class InnerEx4 {
    public static void main(String[] args) {
        //아우터클래스의 인스턴스를 먼저 생성하고,
        //인스턴스클래스의 인스턴스를 생성해야한다.
        Outer oc = new Outer();
        Outer.InstanceInenr ii = oc.new InstanceInenr();

        System.out.println("ii.iv : "+ii.iv);
        System.out.println("Outer.StaticInner.cv : "+ Outer.StaticInner.cv);

        // 내부클래스인 스태틱클래스의 인스턴스는 외부인스턴스가 필요없다.
        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println("si.cv : "+si.iv);
    }
}
