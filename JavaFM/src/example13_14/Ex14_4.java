package example13_14;

import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Stream;

public class Ex14_4 {
    public static void main(String[] args) {
        Stream<Integer> die = IntStream.rangeClosed(1,6).boxed();

        die.flatMap(i->Stream.of(1,2,3,4,5,6).map(i2->new int[]{i,i2}))
                .filter(iArr -> iArr[0]+iArr[1]==6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
