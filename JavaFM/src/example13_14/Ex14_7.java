package example13_14;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex14_7 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(6,1,46).distinct();
        intStream.sorted().forEach(System.out::println);

    }
}
