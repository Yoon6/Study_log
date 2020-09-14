package ch13;
import java.util.concurrent.locks.*;
import java.util.ArrayList;

public class ThreadWaitEx1 {
    public static void main(String[] args) throws Exception{
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}
class Customer implements Runnable{
    private Table table;
    private String food;

    Customer(Table table, String food){
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name+" ate a "+food);
        }
    }
}
class Cook implements Runnable{
    private Table table;
    Cook(Table table){ this.table = table; }
    @Override
    public void run(){
        while(true){
            //임의의 요리 테이블에 추가
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try{ Thread.sleep(10); }catch (InterruptedException e){}
        }
    }
}
class Table{
    String[] dishNames = {"donut","donut","burger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish){
        lock.lock();
        try{
            while(dishes.size()>=MAX_FOOD){
                String name = Thread.currentThread().getName();
                System.out.println(name+" is waiting.");
                try{
                    //wait(); // 음식이 6개 이상이면 COOK쓰레드를 기다리게 한다.
                    forCook.await();
                    Thread.sleep(500);
                }catch (InterruptedException e){}
            }
            dishes.add(dish);
            //notify(); // 기다리고 있는 CUST를 깨우기 위함이다.
            forCust.signal();
            System.out.println("Dished:"+dishes.toString());
        }finally{
            lock.unlock();
        }
    }

    public void remove(String dishName){
        lock.lock();
        String name = Thread.currentThread().getName();
        try{
            while(dishes.size()==0){
                System.out.println(name+" is waiting.");
                try{
                    forCust.await(); // 음식이 없으면 CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e){}
            }
            while(true){
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal(); // 음식을 먹었으면, COOK을 깨움.
                        return;
                    }
                }
                try{
                    System.out.println(name+" is waiting.");
                    forCust.await(); // 원하는 음식이 없으면 CUST를 기다리게 한다.
                    Thread.sleep(500);
                }catch (InterruptedException e){}
            }
        }finally {
            lock.unlock();
        }
    }
    public int dishNum(){ return dishNames.length; }
}