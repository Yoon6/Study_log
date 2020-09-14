package example13_14;

public class Ex13_7 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread5 th = new Thread5();
        th.start();

        try {
            Thread.sleep(6*1000);
        }catch (Exception e){}

        stopped = true;
        Thread1 th1 = new Thread1();
        System.out.println("stopped");
    }
}
class Thread5 extends Thread{
    @Override
    public void run() {
        for(int i=0; !Ex13_7.stopped; i++){
            System.out.println(i);
            try {
                Thread.sleep(5*1000);
            }catch (Exception e){}
        }
    }
}