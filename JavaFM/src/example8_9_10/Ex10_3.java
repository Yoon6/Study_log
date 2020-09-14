package example8_9_10;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex10_3 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###.#");
        DecimalFormat df2 = new DecimalFormat("#,####");
        String data = "123,456,789.5";
        try {
            Number num = df.parse(data);
            double doubleData = num.doubleValue();
            int intData = (int)Math.round(doubleData);
            System.out.println("data:"+data);
            System.out.println("반올림:"+intData);
            System.out.println("만단위:"+df2.format(intData));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
