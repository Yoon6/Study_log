package ch16;
import java.net.*;

public class NetworkEx3 {
    public static void main(String[] args) {
        URL url = null;
        String address = "http://www.codechobo.com/sample/hello.html";

        try{
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString() :"+conn);
            System.out.println("getAllowUserInteraction() :"+conn.getAllowUserInteraction());
            System.out.println("getConnectTimeout() :"+conn.getConnectTimeout());
            System.out.println("getContent() :"+conn.getContent());
            System.out.println("getContentEncoding() :"+conn.getContentEncoding());
            System.out.println("getContentLength() :"+conn.getContentLength());
            System.out.println("getContentType() :"+conn.getContentType());
            System.out.println("getDate() :"+conn.getDate());
            System.out.println("getAllowUserInteraction() :"+conn.getAllowUserInteraction());
            System.out.println("getDefaultUseCaches() :"+conn.getDefaultUseCaches());
            System.out.println("getDoInput() :"+conn.getDoInput());
            System.out.println("getDoOutput() :"+conn.getDoOutput());
            System.out.println("getEx() :"+conn.getDoOutput());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
