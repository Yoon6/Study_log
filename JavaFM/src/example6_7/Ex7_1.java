package example6_7;

public class Ex7_1 {
    public static void main(String[] args) {
        SutdaDeck2 deck = new SutdaDeck2();

        for(int i=0; i<deck.cards.length; i++){
            System.out.print(deck.cards[i]+",");
        }
    }
}

class SutdaDeck2{
    final int CARD_NUM=20;
    SutdaCard2[] cards = new SutdaCard2[CARD_NUM];

    SutdaDeck2(){
        for(int i=0; i<cards.length; i++){
            int num = i%10+1;
            boolean isKwang = (i<10)&&(num==1||num==3||num==8);
            cards[i] = new SutdaCard2(num, isKwang);
        }
    }
    void shuffle(){
        for(int i=0; i<cards.length; i++){
            int j = (int)(Math.random()*cards.length);

            SutdaCard2 temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    SutdaCard2 pick(int index){
        if(index<0||index>cards.length)
            return null;
        return cards[index];
    }
    SutdaCard2 pick(){
        return cards[(int)(Math.random()*cards.length)];
    }
}

class SutdaCard2{
    final int num;
    final boolean isKwang;

    SutdaCard2(){
        this(1, true);
    }
    SutdaCard2(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }
    public String toString(){
        return num + (isKwang?"K":"");
    }
}
