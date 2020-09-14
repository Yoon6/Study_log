package ch6;

public class TVTest {
    public static void main(String[] args) {
        TV t;
        t = new TV();
        t.channel = 7;
        t.channelDown();
        System.out.println("현재 채널은 "+t.channel+" 입니다.");
    }
}

class TV{
    //멤버변수, state
    String color;
    boolean power;
    int channel;

    //메소드,
    void power(){
        power = !power;
    }
    void channelUp(){
        ++channel;
    }
    void channelDown(){
        --channel;
    }
}