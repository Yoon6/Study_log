package ch7;

class A2{
    void autoPlay(I i){
        i.play();
    }
}

interface I{
    void play();
}

class B2 implements I{
    public void play(){
        System.out.println("Play in B Class");
    }
}

class C2 implements I{
    public void play(){
        System.out.println("Play in C Class");
    }
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.autoPlay(new B2());
        a.autoPlay(new C2());
    }
}
