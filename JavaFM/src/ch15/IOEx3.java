package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;

        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Source :"+Arrays.toString(inSrc));

        try{
            while(input.available()>0) { // 스트림으로부터 읽어올 수 있는 데이터 크기
                input.read(temp); // temp에서 input을 읽어온다.
                output.write(temp);
                //System.out.println("temp :"+Arrays.toString(temp));

                outSrc=output.toByteArray();
                printArrays(temp, outSrc);
            }
        }catch (IOException e){}
    }
    static void printArrays(byte[] temp, byte[] outSrc){
        System.out.println("temp :"+Arrays.toString(temp));
        System.out.println("Output Source :"+Arrays.toString(outSrc));
    }
}
