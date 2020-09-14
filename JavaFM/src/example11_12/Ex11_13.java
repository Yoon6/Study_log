package example11_12;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Ex11_13 {
    public static void main(String[] args) throws Exception{
        SutdaDeck deck = new SutdaDeck();

        deck.shuffle();

        Player[] pArr={
                new Player("타짜", deck.pick(), deck.pick()),
                new Player("고수", deck.pick(), deck.pick()),
                new Player("물주", deck.pick(), deck.pick()),
                new Player("중수", deck.pick(), deck.pick()),
                new Player("하수", deck.pick(), deck.pick())
        };

        TreeMap rank = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // code
                if(o1 instanceof Player&&o2 instanceof Player) {
                    Player p1 = (Player) o1;
                    Player p2 = (Player) o2;

                    return p2.point-p1.point;
                }
                return -1;
            }
        });

        for(int i=0; i<pArr.length; i++){
            Player p = pArr[i];
            rank.put(p, deck.getPoint(p));
            System.out.println(p+" "+deck.getPoint(p));
        }
        System.out.println();
        System.out.println("1위는 "+rank.firstKey()+"입니다.");
    }
}
