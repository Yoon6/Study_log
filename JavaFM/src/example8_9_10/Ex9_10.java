package example8_9_10;

public class Ex9_10 {
    public static String format(String str, int length, int alignment){
        if(length<=str.length())
            return str.substring(0,length);
        char[] ch = new char[length];
        for(int i=0; i<ch.length; i++)
            ch[i]=' ';
        switch (alignment){
            case 0:
                System.arraycopy(str.toCharArray(), 0, ch, 0, str.length());
                break;
            case 1:
                System.arraycopy(str.toCharArray(), 0, ch, (length-str.length())/2, str.length());
                break;
            case 2:
                System.arraycopy(str.toCharArray(), 0, ch, length-str.length(), str.length());
                break;
            default:
                break;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String str = "가나다";

        System.out.println(format(str, 7, 0));
        System.out.println(format(str, 7, 1));
        System.out.println(format(str, 7, 2));
    }
}
