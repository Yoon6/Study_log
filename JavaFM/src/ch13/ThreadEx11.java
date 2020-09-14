package ch13;
import java.util.*;

public class ThreadEx11 {
    public static void main(String[] args) {
        ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
        ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
        t1.start();
        t2.start();
    }
}
class ThreadEx11_1 extends Thread{
    ThreadEx11_1(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(5*1000);
        }catch (InterruptedException e){}
    }
}
class ThreadEx11_2 extends Thread{
    ThreadEx11_2(String name){
        super(name);
    }

    @Override
    public void run() {
        Map map = getAllStackTraces(); // 실행중이나 대기상태의 쓰레드의 호출 스택을 출력할 수 있다.
        Iterator it = map.keySet().iterator(); // key값을 set으로

        int x=0;
        while(it.hasNext()){
            Object obj = it.next();
            Thread t = (Thread)obj;
            StackTraceElement[] ste = (StackTraceElement[])(map.get(obj)); // key값에 대응되는 value

            System.out.println("["+ ++x +"] name : "+t.getName()+", group : "
                    +t.getThreadGroup().getName()+", daemon : "+t.isDaemon());

            for(int i=0; i<ste.length; i++){
                System.out.println(ste[i]);
            }
            System.out.println();
        }

    }
}