package ch14;
@FunctionalInterface
interface MyFunction2{
    void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction2 f = () -> {}; // 형변환 생략
        Object obj = (MyFunction2)(()->{}); // Object로 형변환 생략
        String str = ((Object)(MyFunction2)(()->{})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        //System.out.println(()->{}); // 람다식은 Object타입으로 형변환 불가
        System.out.println((MyFunction2)(()->{}));
        //System.out.println((MyFunction2)(()->{}).toString()); // toString()을 사용할 수 없음
        System.out.println(((Object)(MyFunction2)(()->{})).toString());
    }
}
