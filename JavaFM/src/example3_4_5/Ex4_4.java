package example3_4_5;

public class Ex4_4 {
    public static void main(String[] args) {
        int sum = 0;
        int pre;
        int i = 0;
        int s = 1;
        int sum2 = 0;
        while(true){
            pre = i%2==0? -1:1;
            sum += pre*i;

            if(sum>=100){
                System.out.println("sum = "+sum);
                System.out.println("i = "+i);
                break;
            }
            i++;
        }

        for(int j=1; true; j++, s=-s){
            sum2 += j*s;
            if(sum2>=100){
                System.out.println("sum2 = "+sum);
                System.out.println("j = "+j);
                break;
            }
        }

    }
}
