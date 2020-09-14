package example8_9_10;

public class Ex9_3 {
    public static void main(String[] args) {
        String fullPath = "C:\\Users\\Yoon\\IdeaProjects\\JavaFM\\src\\BufferedReaderEx1.java";
        String path="";
        String fileName="";

        int pos = fullPath.lastIndexOf("\\");
        if(pos!=-1){
            path = fullPath.substring(0,pos);
            fileName = fullPath.substring(pos+1);
        }

        System.out.println("fullPath:"+fullPath);
        System.out.println("path:"+path);
        System.out.println("FileName:"+fileName);
    }
}
