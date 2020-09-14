package example8_9_10;

import static java.time.DayOfWeek.*;
import java.time.*;
import static java.time.temporal.TemporalAdjusters.*;
import java.util.Calendar;

public class Ex10_7 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016,12,1);
        LocalDate fourthTuesday = date.with(dayOfWeekInMonth(4, TUESDAY));

        System.out.println(fourthTuesday);
    }
}
