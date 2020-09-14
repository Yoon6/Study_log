package example6_7;

public class Ex6_7 {
    public static void main(String[] args) {
        MyPoint p = new MyPoint(1,1);

        System.out.println(p.getDistance(2,2));
    }
}

class MyPoint{
    int x;
    int y;

    MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    double getDistance(int x2, int y2){
        return Math.sqrt((x2-x)*(x2-x)+(y2-y)*(y2-y));
    }
}