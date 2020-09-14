package example13_14;

import javax.swing.*;

public class Ex13_9 {
    public static void main(String[] args) {
        Ex13_9_1 th = new Ex13_9_1();
        //th.setDaemon(true);
        th.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 "+input+"입니다.");
        th.interrupt();
    }
}
class Ex13_9_1 extends Thread{
    @Override
    public void run() {
        int i=10;
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                interrupt();
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
