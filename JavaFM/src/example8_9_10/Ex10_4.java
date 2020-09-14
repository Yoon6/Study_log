package example8_9_10;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex10_4 {
    public static void main(String[] args) {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Scanner sc = new Scanner(System.in);
        Date d=null;
        while (true) {
            System.out.println("날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)");
            System.out.print(">>");
            String date = sc.nextLine();
            try {
                d = sdf.parse(date);

                break;
            } catch (Exception e) {

            }
        }
        System.out.println(new SimpleDateFormat("입력하신 날짜는 E요일입니다.").format(d));
    }
}
