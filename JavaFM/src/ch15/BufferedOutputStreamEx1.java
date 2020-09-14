package ch15;
import java.io.*;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try{
            FileOutputStream fos = new FileOutputStream("123.txt");
            // 버퍼 크기 5 (byte배열)
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            // 파일 123.txt에 1부터 9까지 출력.
            for(int i='1';i<='9'; i++){
                bos.write(i);
            }
            bos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
