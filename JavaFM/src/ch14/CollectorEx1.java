package ch14;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CollectorEx1 {
    public static void main(String[] args) {
        String[] strArr = {"aaa","bbb","ccc"};
        Stream<String> strStream = Stream.of(strArr);

        String result = strStream.collect(new ConcatCollector());

        System.out.println(Arrays.toString(strArr));
        System.out.println("result="+result);
    }
}
class ConcatCollector implements Collector<String, StringBuffer, String>{
    @Override
    public Supplier<StringBuffer> supplier(){
        return ()->new StringBuffer();
    }

    @Override
    public BiConsumer<StringBuffer, String> accumulator() {
        return (sb, s)->sb.append(s);
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        return sb->sb.toString();
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {
        return (sb,sb2)->sb.append(sb2);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}