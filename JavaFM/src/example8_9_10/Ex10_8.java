package example8_9_10;

import java.time.*;
import java.time.temporal.ChronoField;

public class Ex10_8 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId seoul_zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime seoul_zdt = dateTime.atZone(seoul_zid);
        ZoneId newyork_zid = ZoneId.of("America/New_York");
        ZonedDateTime newyork_zdt = ZonedDateTime.now().withZoneSameInstant(newyork_zid);

        System.out.println(seoul_zdt);
        System.out.println(newyork_zdt);

        ZoneOffset krOffset = seoul_zdt.getOffset();
        ZoneOffset nyOffset = newyork_zdt.getOffset();
        int sec1 = krOffset.getTotalSeconds();
        int sec2 = nyOffset.getTotalSeconds();
        System.out.println("sec1="+sec1);
        System.out.println("sec2="+sec2);

        int diff = (int)(Math.abs(sec1-sec2))/(60*60);
        System.out.println("diff="+diff+" hrs");
    }
}
