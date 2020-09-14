package ch12;
import java.util.*;

class AppleComp implements Comparator<Apple>{ // 오름차순
    @Override
    public int compare(Apple apple, Apple t1) {
        return t1.weight-apple.weight;
    }
}
class GrapeComp implements Comparator<Grape>{ // 오름차순
    @Override
    public int compare(Grape grape, Grape t1) {
        return t1.weight-grape.weight;
    }
}
class FruitComp implements Comparator<Fruit>{ // 내림차순
    @Override
    public int compare(Fruit fruit, Fruit t1) {
        return fruit.weight-t1.weight;
    }
}
public class FruitBoxEx4 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        appleBox.add(new Apple("GreenApple",300));
        appleBox.add(new Apple("GreenApple",100));
        appleBox.add(new Apple("GreenApple",200));

        grapeBox.add(new Grape("GreenGrape",400));
        grapeBox.add(new Grape("GreenGrape",300));
        grapeBox.add(new Grape("GreenGrape",200));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println();
        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println();
    }
}
