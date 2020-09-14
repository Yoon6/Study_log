package ch6;

public class ReferenceParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main90 : x = " + d.x);

        ReferenceParamEx referPram = new ReferenceParamEx();
        referPram.change(d);
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x);
    }
    void change(Data d){
        d.x = 1000;
        System.out.println("change() : x = " + d.x);
    }
}
