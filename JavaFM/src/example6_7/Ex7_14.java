package example6_7;

public class Ex7_14 {
    public static void main(String[] args) {
        SutdaCard2 card = new SutdaCard2(1, true);
    }
}
abstract class Unit{
    int x,y;
    abstract void move(int x, int y);
    void stop(){}
}
class Marine extends Unit{
    @Override
    void move(int x, int y) {

    }

    void stimPack(){}
}
class Tank extends Unit{
    @Override
    void move(int x, int y) {

    }

    void changeMode(){}
}
class Dropship extends Unit{
    @Override
    void move(int x, int y) {

    }

    void load(){}
    void unload(){}
}