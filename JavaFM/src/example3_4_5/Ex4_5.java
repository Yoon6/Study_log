package example3_4_5;

public class Ex4_5 {
    public static void main(String[] args) {
        int i=1;
        while(i<=10){
            int count = 0;
            while (count<i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }
    }
}
