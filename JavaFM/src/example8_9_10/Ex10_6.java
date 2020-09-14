package example8_9_10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Ex10_6 {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar birthday = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        birthday.set(2000,5,6);
        Date dateBirth = new Date(birthday.getTimeInMillis());
        Date dateToday = new Date(today.getTimeInMillis());
        long day = (today.getTimeInMillis()-birthday.getTimeInMillis())/(60*60*24*1000);

        System.out.println("birth day="+df.format(dateBirth));
        System.out.println("today    ="+df.format(dateToday));
        System.out.println(day+" days");

        LocalDate birth = LocalDate.of(2000,6,6);
        LocalDate now = LocalDate.now();

        long days = birth.until(now, ChronoUnit.DAYS);

        System.out.println("birth day="+birth);
        System.out.println("now      ="+now);
        System.out.println(days+" days");
    }
}
