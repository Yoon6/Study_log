package example3_4_5;

public class Ex4_12 {
    public static void main(String[] args) {
        for(int i=2; i<9; i+=3){
            for(int j=1; j<=3; j++){
                System.out.print(i+"*"+j+"="+i*j+"\t\t");
                System.out.print((i+1)+"*"+j+"="+(i+1)*j+"\t\t");
                if(i+2<10) {
                    System.out.print((i + 2) + "*" + j + "=" + (i + 2) * j + "\t\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int i=1; i<=9; i++){
            for (int j=1; j<=3; j++){
                //int x = (j+1)+(i-1)/3*3
                int y = i%3==0? 3:i%3;
                int x = (j+1)+i-y;

                if(x>9)
                    break;
                System.out.print(x+"*"+y+"="+x*y+"\t");
            }
            System.out.println();
            if(i%3==0) System.out.println();
        }
    }
}
