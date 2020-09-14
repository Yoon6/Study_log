package ch12;
import java.util.*;

class Fruit implements Eatable {
    String name;
    int weight;
    Fruit(String name, int weight){
        this.name=name;
        this.weight=weight;
    }
    Fruit(){
        this.name="Fruit";
        this.weight=0;
    }

    public String toString(){return name+"("+weight+")";}
}
class Apple extends Fruit {
    Apple(String name, int weight){
        super(name, weight);
    }
    Apple(){}
}
class Grape extends Fruit {
    Grape(String name, int weight){
        super(name, weight);
    }
    Grape(){}
}
class Toy {public String toString(){return "Toy";}}

interface Eatable{}

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Toy> toyBox = new Box<>();
        //Box<Grape> grapeBox = new Box<Apple>(); // 에러! 타입 불일치!

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); // 다형성

        appleBox.add(new Apple());
        appleBox.add(new Apple());

        toyBox.add(new Toy());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }
}

class Box<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item){list.add(item);}
    T get(int i){return list.get(i);}
    ArrayList<T> getList() { return list; }
    int size(){return list.size();}
    public String toString(){ return list.toString(); }
}