package example15;
import java.io.*;

public class DirectoryInfoTest {
    static int totalFiles = 0;
    static int totalDirs = 0;
    static int totalSize = 0;

    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("USAGE : java DirectoryInfoTest DIRECTORY");
            System.exit(0);
        }
        File dir = new File(args[0]);
        if(!dir.exists()||!dir.isDirectory()){
            System.out.println("not valid directory.");
            System.exit(0);
        }
        countFiles(dir);

        System.out.println();
        System.out.println("Total "+totalFiles+"files");
        System.out.println("Total "+totalDirs+"directories");
        System.out.println("Size : "+totalSize+" bytes");
    }

    public static void countFiles(File dir){
        File[] files = dir.listFiles();

        for(int i=0; i<files.length; i++){
            if(files[i].isDirectory()){
                totalDirs++;
                countFiles(files[i]);
            }else{
                totalFiles++;
                totalSize+=files[i].length();
            }
        }
    }
}
