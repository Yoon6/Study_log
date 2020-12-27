import java.io.*;

/*
* 매크로 프로세서 설계
*
* 매크로 1개에 대해서 수행한다.
* 이중 패스 매크로를 설계하였다.
*
* Macro 클래스에서 입력 파일들을 배열로 바꿔
* */

public class Macro {
    static String[] input1 = new String[100]; // 파일 입력 줄 단위로 받기
    static String[][] input2 = new String[100][]; // 파일 입력 줄 - 단어 단위로 받기

    public static void main(String[] args) {

        // Pass1에 배열로 변환된 input.txt 전달
        fileToArray(input1, input2, "input.txt");
        new Pass1(input1, input2);

        // 배열 초기화
        input1 = new String[100];
        input2 = new String[100][];

        // Pass2에 배열로 변환된 temp.txt(Pass1의 출력) 전달
        fileToArray(input1, input2, "temp.txt");
        new Pass2(input1, input2);

    }

    // 파일 입력을 배열로 바꿈
    public static void fileToArray(String[] str1, String[][] str2, String fileName){
        try{
            File file = new File("./src/"+fileName); // 해당 경로에서 파일을 읽어옴
            // 입력 스트림
            FileReader fileReader = new FileReader(file);
            // 입력 버퍼
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";

            for(int i=0; (line=bufferedReader.readLine())!=null; i++){
                str1[i] = line; // 배열에 파일 한 줄 씩을 저장함
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0; str1[i]!=null; i++){
            str2[i] = str1[i].split("\\s+|,"); // 한줄에 있는 단어(명령어, 연산항) 별로 나누서 저장함
        }

    }
}

