package example3_4_5;

public class Ex4_3 {
    public static void main(String[] args) {
        int sum = 0;
        int sum2 = 0;
        int totalSum = 0;
        for(int i = 0; i<10; i++){
            for(int j = 1; j <=i+1; j++){
                sum += j;
            }
        }
        for(int i=1; i<=10; i++){
            sum2 += i;
            totalSum += sum2;
        }

        System.out.println(sum);
        System.out.println(totalSum);
    }
}
