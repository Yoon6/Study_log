package example13_14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Ex14_6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa","bb","c","dddd"};
        Stream<String> strStream = Arrays.stream(strArr);

        OptionalInt max = strStream.mapToInt(String::length).max();
        System.out.println(max.getAsInt());

        strStream = Arrays.stream(strArr);
        strStream.map(String::length).sorted(Comparator.reverseOrder())
                .limit(1).forEach(System.out::println);
    }
}
