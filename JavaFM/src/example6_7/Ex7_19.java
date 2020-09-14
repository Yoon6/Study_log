package example6_7;

import java.util.Arrays;

public class Ex7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv2());
        b.buy(new Computer());
        b.buy(new Tv2());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());

        b.summary();
    }
}
class Buyer{
    int money = 1000;
    Product2[] cart = new Product2[3];
    int i=0;

    void buy(Product2 p){
        if(money<p.price)
            return;
        else
            money -= p.price;
        add(p);
    }
    void add(Product2 p){
        if(cart.length<=i){
            Product2[] temp = new Product2[cart.length*2];
            System.arraycopy(cart,0,temp,0,cart.length);
            cart = temp;
        }
        cart[i]=p;
        i++;
    }
    void summary(){
        int sum=0;
        System.out.println(Arrays.toString(cart));
        for(int i=0; i<cart.length; i++){
            sum += cart[i].price;
        }
        System.out.println("total price : "+sum);
        System.out.println("money :"+money);
    }
}
class Product2{
    int price;
    Product2(int price){
        this.price=price;
    }
}
class Tv2 extends Product2{
    Tv2(){super(100);}
    public String toString(){ return "TV"; }
}
class Computer extends Product2{
    Computer() {super(200);}
    public String toString(){ return "Computer"; }
}
class Audio extends Product2{
    Audio(){ super(50);}
    public String toString(){ return "Audio"; }
}