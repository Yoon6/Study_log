package example6_7;

public class Ex6_1 {
}
class SutdaCard{
    int num;
    boolean isKwang;

    SutdaCard(){
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang){
        if(1<=num&&num<=10){
            this.num=num;
        }
        this.isKwang = isKwang;
    }

    public String info(){
        return num+(isKwang?"K":"");
    }
}