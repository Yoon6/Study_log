package ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaEx6 {
    public static void main(String[] args) {
        IntSupplier s = ()->(int)(Math.random()*100)+1;
        IntConsumer c = i -> System.out.print(i+", ");
        IntPredicate p = i -> i%2==0;
        IntUnaryOperator op = i->i/10*10; // 10으로 나눠서 1의자리 없애고 다시 10곱함

        int[] arr = new int[10];

        makeRandomList(s, arr); // 1~100까지 저장
        System.out.println(Arrays.toString(arr)); // 출력
        printEvenNum(p, c, arr); // p.test(i)로 짝수 true면 c.accept(i)로 출력
        int[] newArr = doSomething(op, arr); // 계산한 값을 AL형으로 반환
        System.out.println(Arrays.toString(newArr)); // 새로운 리스트 출력
    }
    static int[] doSomething(IntUnaryOperator op, int[] arr){
        int[] newArr = new int[arr.length];

        for(int i=0; i<newArr.length; i++){
            newArr[i] = op.applyAsInt(arr[i]);
        }
        return newArr;
    }
    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr){
        System.out.print("[");
        for(int i:arr){
            if(p.test(i))
                c.accept(i);
        }
        System.out.println("]");
    }
    static void makeRandomList(IntSupplier s, int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=s.getAsInt();
        }
    }
}
