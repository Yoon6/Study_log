package ch14;
public class Praatice {

    public static void main(String[] args) {
        Praatice.guitar g = new Praatice().new guitar();
        g.bonuspick=1500;
        g.bonuspicks();
        g.manufacturer="fender";
        g.manufacturetime="30days";

        System.out.println(g.bonuspick);
        System.out.println(g.manufacturer);
    }

    class guitar{
        int bonuspick;
        String manufacturer;
        String manufacturetime;
        boolean pickupSelector;

        void pickupselector() {pickupSelector=!pickupSelector;}
        void bonuspicks() {++bonuspick;}

    }
}