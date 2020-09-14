package example8_9_10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Ex10_5 {
    public static int getDayDiff(String yyyymmdd1, String yyyymmdd2){
        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        long day=0;
        try {
            Date d1 = df.parse(yyyymmdd1);
            Date d2 = df.parse(yyyymmdd2);

            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(d1);
            cal2.setTime(d2);

            day = Math.abs(cal1.getTimeInMillis()-cal2.getTimeInMillis())/(60*60*24*1000);

        }catch (Exception e){
            return 0;
        }
        return (int)day;
    }

    public static void main(String[] args) {
        System.out.println(getDayDiff("20010103","20010101"));
        System.out.println(getDayDiff("20010103","20010103"));
        System.out.println(getDayDiff("20010103","200103"));
    }
}
