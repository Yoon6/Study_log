package ch6;

public class ReferenceReturnEx {
    public static void main(String[] args) {
        ReferenceReturnEx rr = new ReferenceReturnEx();

        Data d = new Data();
        d.x = 10;

        Data d2 = rr.copy(d);
        System.out.println("d.x =" + d.x);
        System.out.println("d2.x =" + d2.x);
    }
    Data copy(Data d){
        Data tmp = new Data();
        tmp.x = d.x;
        return tmp;
    }
}
