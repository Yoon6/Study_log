package example8_9_10;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ex10_1 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2010,0,1);

        for(int i=0; i<12; i++){
            int weekday = cal.get(Calendar.DAY_OF_WEEK);

            //cal의 요일이 1(일요일)이면 7일뒤인 8일이 일요일, 아니면 2주에서 요일숫자 뺌
            int secondSunday = (weekday==1)?8:16-weekday;
            cal.set(Calendar.DATE, secondSunday);
            Date d = new Date(cal.getTimeInMillis());
            System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));

            cal.add(Calendar.MONTH,1);
            cal.set(Calendar.DAY_OF_MONTH,1);
        }
    }
}
