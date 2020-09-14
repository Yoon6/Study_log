package example6_7;
class MyTv2{
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int prev_channel;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if(channel>MAX_CHANNEL||channel<MIN_CHANNEL)
            return;
        prev_channel = this.channel;
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume>MAX_VOLUME||volume<MIN_VOLUME)
            return;
        this.volume = volume;
    }
    public void gotoPrevChannel(){
        setChannel(prev_channel);
    }

    /*
    void gotoPrevChannel(){
        if(prev_channel==0)
            return;
        int temp = channel;
        channel = prev_channel;
        prev_channel = temp;
    }

     */
}
public class Ex7_10 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH:"+t.getChannel());
        t.setVolume(20);
        System.out.println("VOL:"+t.getVolume());
    }
}
