package ch7;

public class FightTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();

        if(f instanceof Unit_1){
            System.out.println("f는 Unit클래스의 자손입니다.");
        }
        if(f instanceof Fightable){
            System.out.println("f는 Fightable의 메소드를 구현했습니다.");
        }
        if(f instanceof Movable){
            System.out.println("f는 Movable의 메소드를 구현했습니다.");
        }
        if(f instanceof Attackable){
            System.out.println("f는 Attackable의 메소드를 구현했습니다.");
        }
        if(f instanceof Object){
            System.out.println("f는 Object클래스의 자손입니다.");
        }
    }
}

class Fighter extends Unit_1 implements Fightable{
    public void move(int x, int y){
        // ...
    }
    public void attack(Unit_1 u){
        // ...
    }

}
class Unit_1 {
    int currentHP;
    int x;
    int y;
}
interface Fightable extends Movable, Attackable{}
interface Movable {
    void move(int x, int y);
}
interface Attackable{
    void attack(Unit_1 u);
}