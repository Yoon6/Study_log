package ch4;

import java.util.Scanner;

public class FlowEx9 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';

        System.out.print("당신의 점수를 입력하세요. (1~100)>");

        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        score = Integer.parseInt(tmp);

        switch (score){
            case 100:
                System.out.println("이후로는 패스");
        }
    }
}
