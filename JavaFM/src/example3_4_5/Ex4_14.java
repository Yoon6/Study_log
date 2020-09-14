package example3_4_5;

import java.util.Scanner;

public class Ex4_14 {
    public static void main(String[] args) {
        // 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
        int answer =  (int)(Math.random()*100)+1;
        int input = 0; // 사용자 입력
        int count = 0; // 시도 횟수

        // 화면으로부터 사용자입력
        Scanner s = new Scanner(System.in);

        do{
            count++;
            System.out.print("1과 100사이의 값을 입력하세요 :");
            input = s.nextInt();

            if(input == answer){
                System.out.println("맞췄습니다.");
                System.out.println("시도횟수는 "+count+"번입니다.");
                break;
            }else if(input > answer){
                System.out.println("더 작은 수를 입력하세요.");
            }else{
                System.out.println("더 큰 수를 입력하세요.");
            }
        }while (true);
    }
}
