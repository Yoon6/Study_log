package example13_14;

public class Ex13_5 {
    public static void main(String[] args) throws Exception {
        Thread3 th = new Thread3();
        th.start();

        try {
            Thread.sleep(5*1000);
        }catch (Exception e){}

        throw new Exception("꽝~!!!");
    }
}
class Thread3 extends Thread{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}