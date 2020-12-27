import java.io.*;

class Pass1 {

    String[] ori; // 입력 소스코드를 줄 단위로 저장하는 배열
    String[][] str; // 입력 소스코드를 줄과 단어별로 저장하는 배열
    static int MNTC = 1, MDTC = 1, formal_COUNT = 0;
    static String[][] formal_table = new String[50][2]; // 형식 인수표 저장하는 배열

    Pass1(String[] ori, String[][] str) {
        this.str = str;
        this.ori = ori;
        search_macro();
    }

    // 매크로 탐색 메소드
    public void search_macro() {
        for (int i = 0; str[i] != null; i++) {
            if (str[i][1].equals("MACRO")) { // 매크로 명령어면,

                write_MNT(i); // MNT에 작성
                formal_arg_table(i); // 형식 인수표 작성

                i+=(MDTC-1); // 매크로 크기만큼 i 점프
            }
            else{ // 매크로가 아니면
                write_out(i); // temp.txt에 출력
            }
        }

    }

    // 매크로가 아닌 명령어 포함
    public void write_out(int n){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./src/temp.txt", true));
            PrintWriter pw = new PrintWriter(bw, true);
            pw.write(ori[n]+"\n");

            pw.flush();
            pw.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    // MNT 작성 메소드
    public void write_MNT(int n) {
        try {
            // MNT.txt에 표 저장
            File file = new File("./src/MNT.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if (file.isFile() && file.canWrite()) {

                bufferedWriter.write(MNTC + "\t"); // MNT 색인
                bufferedWriter.write(str[n][0] + "\t"); // 매크로명
                bufferedWriter.write(MDTC + "\t"); // MDT 색인
                bufferedWriter.newLine(); // 줄바꿈

                bufferedWriter.close();
                MNTC++; // MNTC = MNTC+1
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // MDT 작성 메소드
    public void write_MDT(int n) { // 인덱스 번호
        try {
            //파일 객체 생성
            File file = new File("./src/MDT.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if (file.isFile() && file.canWrite()) {


                int i = 0;
                bufferedWriter.write(MDTC + "\t" + ori[n] + "\n"); // 매크로 명령어 행 쓰기
                MDTC++;
                n++;
                while (true) {
                    if (str[n][i].equals("ENDM")) { // ENDM명령어가 나오면 쓰기 종료
                        bufferedWriter.write(str[n][i]);
                        break;
                    }

                    if (i == 0) { //
                        bufferedWriter.write(MDTC + "\t");
                        if (str[n][0].equals("")) bufferedWriter.write("\t\t"); // [n][0]번 배열 공백 처리
                        else bufferedWriter.write(str[n][0] + "\t");
                    }

                    if (i == 1) {
                        bufferedWriter.write(str[n][i] + "\t\t"); // 명령어
                    }

                    if (i >= 2) {

                        for (int k = 0; k < formal_table.length; k++) {
                            if (str[n][i].equals(formal_table[k][0])) {
                                str[n][i] = formal_table[k][1];
                            }
                        }
                        if (i == (str[n].length - 1))
                            bufferedWriter.write(str[n][i]);
                        else
                            bufferedWriter.write(str[n][i] + ",");
                    }

                    i++;

                    if (i == str[n].length) {
                        n++;
                        i = 0;
                        bufferedWriter.newLine();
                        MDTC++;
                    }
                }

                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 형식인수표 작성 메소드
    public void formal_arg_table(int n) {
        try {
            File file = new File("./src/formal_arg_table.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if (file.isFile() && file.canWrite()) {

                for (int i = 2, k = 0; i < str[n].length; i++, k++) {

                    // 형식 인수표 배열에 저장
                    formal_table[k][0] = str[n][i];
                    formal_table[k][1] = "#" + formal_COUNT;

                    // 형식인수, 색인 작성
                    bufferedWriter.write(formal_table[k][0] + "\t" +formal_table[k][1]);
                    bufferedWriter.newLine();
                    formal_COUNT++;
                }

                bufferedWriter.close();

                write_MDT(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
