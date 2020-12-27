import java.io.*;

class Pass2{
    String[] ori;
    String[][] str;
    static int MDTP;
    String[] mnt;
    String[] mdt = new String[100];
    String[][] split_mdt=new String[100][];
    static String[][] actual= new String[100][2];

    Pass2(String[] ori, String[][] str){
        this.ori=ori;
        this.str=str;

        read_MNT(); // MNT표 읽어서 mnt배열에 저장
        read_input();
    }

    public void read_input(){
        for(int i=0; str[i]!=null; i++){

            if(mnt[1].equals(str[i][1])){ // 매크로 표에 있으면,
                MDTP=Integer.parseInt(mnt[0]);
                actual_arg_table(i); // 실인수표 작성
                write_macro(i); // 매크로 내용으로 치환

            }else{ // 아니면
                write_output(i); // 그냥 출력
            }
        }
    }

    // MNT표 읽어서 배열에 저장
    public void read_MNT(){
        try{
            File file = new File("./src/MNT.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";

            for(int i=0; (line=bufferedReader.readLine())!=null; i++){
                mnt=line.split("\\s+"); // mnt배열에 나눠서 저장
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // MDT표 읽어서 배열에 저장
    public void read_MDT(){
        try{
            File file = new File("./src/MDT.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";

            for(int i=0; (line=bufferedReader.readLine())!=null; i++){
                mdt[i] = line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0; mdt[i]!=null; i++){
            split_mdt[i] = mdt[i].split("\\s+|,");
        }
    }

    // 매크로 부분 작성
    public void write_macro(int n){
        MDTP++;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./src/output.txt",true));
            PrintWriter pw = new PrintWriter(bw, true);

            read_MDT(); // MDT표 읽기

            for(int i=MDTP-1; !split_mdt[i][1].equals("ENDM"); i++){ // ENDM이 나올 때 까지 출력
                pw.write("\t");
                for(int k=1; k<split_mdt[i].length; k++) {
                    for(int j=0; j<actual.length; j++){
                        if(split_mdt[i][k].equals(actual[j][0]))
                            split_mdt[i][k]=actual[j][1];
                    }
                    if(k==1) {
                        pw.write(split_mdt[i][k]+"\t\t");
                    }else{
                        if(k==split_mdt[i].length-1)
                            pw.write(split_mdt[i][k]);
                        else
                            pw.write(split_mdt[i][k]+",");
                    }
                }
                pw.write("\n");
            }

            pw.flush();
            pw.close();

        }catch (IOException ie){
            ie.printStackTrace();
        }

    }

    // 매크로 아닌 부분 작성
    public void write_output(int n){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./src/output.txt",true));
            PrintWriter pw = new PrintWriter(bw, true);

            pw.write(ori[n]+"\n"); // 행별로 그대로 출력
            pw.flush();
            pw.close();

        }catch (IOException ie){
            ie.printStackTrace();
        }
    }

    public void actual_arg_table(int n){
        try {
            //파일 객체 생성
            File file = new File("./src/actual_arg_table.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if (file.isFile() && file.canWrite()) {

                for (int i = 2, k=0; i < str[n].length; i++,k++) {
                    // 실인수표 배열에 저장
                    actual[k][0]=Pass1.formal_table[k][1];
                    actual[k][1]=str[n][i];
                    // 색인, 실인수 쓰기
                    bufferedWriter.write(Pass1.formal_table[k][1] + "\t" + str[n][i]);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
