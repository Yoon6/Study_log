package ch7;

class TV{
    boolean power;
    int channel;

    void power(){ power = !power; }
    void channelUP(){ ++channel; }
    void channelDown(){ --channel; }
}
class CaptionTV extends TV{
    boolean caption;
    void displayCaption(String text){
        if(caption){
            System.out.println(text);
        }
    }
}
public class CaptionTVTest {
    public static void main(String[] args) {
        CaptionTV ctv = new CaptionTV();
        ctv.channel = 10;
        ctv.channelUP();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello, World");
        ctv.caption = true;
        ctv.displayCaption("Hello, World");
    }
}
