package example8_9_10;

public class Ex9_11 {
    public static void gugudan(int start, int end){
        for(int i = start; i<=end; i++) {
            for (int j = 1; j <= 9; j++)
                System.out.println(i + "*" + j + "=" + i * j);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("start number, end number, insert two number");
            System.out.println("USAGE : GugudanTest 3 5");
            System.exit(0);
        }
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        if((start<2||start>9||end<2||end>9)||(start>end)){
            System.out.println("arrange of start to end is 2-9");
            System.out.println("USAGE : GugudanTest 3 5");
            System.exit(0);
        }

        gugudan(start, end);
    }
}
