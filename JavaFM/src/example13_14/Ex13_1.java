package example13_14;

public class Ex13_1 {
    public static void main(String[] args) {
        Runnable r = new Thread1();
        Thread th = new Thread(r);

        th.start();
    }
}
class Thread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<300; i++){
            System.out.print('-');
        }
    }
}
