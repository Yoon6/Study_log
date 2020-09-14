package example3_4_5;

public class Ex4_10 {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;
        int num2 = 12345;
        int sum2 = 0;

        int k;
        for(int i=0; i<5; i++) {
            k = num % 10;
            num /= 10;
            sum += k;
        }

        while(num2>0){
            sum2 += num2%10;
            num2 /= 10;
        }

        System.out.println("sum="+sum);
        System.out.println("sum2="+sum2);
    }
}
