package example15;

import java.io.*;

public class Ex15_1 {
    public static void main(String[] args) {
        try {
            int fileNum = Integer.parseInt(args[0]);
            String fileName = args[1];

            File f = new File(fileName);
            if(f.exists()&&!f.isDirectory()){
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line = "";
                int i=1;
                while ((line=br.readLine())!=null&&i<=fileNum){
                    System.out.println(i+":"+line);
                    i++;
                }
            }else {
                throw new FileNotFoundException(fileName+
                        "is directory, or is not exist.");
            }
        }catch (FileNotFoundException e){
            e.getMessage();
        }catch (Exception e){
            System.out.println("USAGE: java Ex15_1 10 FILENAME");
        }
        /*
        if(args.length!=2){
            System.out.println("USAGE : java Ex15_1 10 FILENAME");
            System.exit(0);
        }
        int num = Integer.parseInt(args[0]);
        String filename = args[1];
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            for(int i=0; i<num; i++){
                line = br.readLine();
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("not exist");
        }
         */
    }
}
