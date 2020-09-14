package ch5;

public class Kakao {
    public static void main(String[] args) {
        int week = 26;
        int fir = 1000;
        int sum = 0;

        for(int i=0; i < week; i++){

            sum += fir;
            fir += 1000;
        }

        System.out.println(sum);
    }
}
