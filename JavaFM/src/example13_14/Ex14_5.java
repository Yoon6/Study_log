package example13_14;

import java.util.Arrays;
import java.util.stream.*;

public class Ex14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa","bb","c","dddd"};
        Stream<String> strStream = Arrays.stream(strArr);

        int sum = strStream.mapToInt(String::length).sum();
        System.out.println("sum="+sum);
    }
}
