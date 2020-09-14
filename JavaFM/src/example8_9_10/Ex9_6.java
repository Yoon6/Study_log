package example8_9_10;

public class Ex9_6 {
    public static String fillZero(String src, int length){
        if(src==null||src.length()==length)
            return src;
        if(length<=0)
            return "";
        if(src.length()>length){
            /*
            char[] ch = new char[length];
            System.arraycopy(src.toCharArray(), 0, ch, 0, length);
            return new String(ch);
             */
            return src.substring(0,length);
        }
        char[] ch = new char[length];
        for(int i=0; i<ch.length; i++){
            ch[i]='0';
        }
        System.arraycopy(src.toCharArray(), 0, ch, length-src.length(), src.length());
        return new String(ch);
    }

    public static void main(String[] args) {
        String src = "12345";
        System.out.println(fillZero(src, 10));
        System.out.println(fillZero(src, -1));
        System.out.println(fillZero(src, 3));
    }
}
