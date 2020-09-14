package ch7;

public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe; //자식클래스의 참조변수를 형변환하여 대입
        //car는 FireEngine의 메소드를 사용할 수 없음
        fe2 = (FireEngine)car;
        fe2.water();
    }
}

class Car{
    String color;
    int door;

    void drive(){
        System.out.println("drive, brrrr~");
    }

    void stop(){
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car{
    void water(){
        System.out.println("water!!!");
    }
}