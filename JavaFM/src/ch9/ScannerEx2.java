package ch9;

import java.util.Scanner;
import java.io.File;

public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(ScannerEx2.class.getResourceAsStream("data2.txt"));
        int sum = 0;
        int cnt = 0;

        while(sc.hasNextInt()){
            sum += sc.nextInt();
            cnt++;
        }

        System.out.println("sum="+sum);
        System.out.println("average="+(double)sum/cnt);

    }
}
