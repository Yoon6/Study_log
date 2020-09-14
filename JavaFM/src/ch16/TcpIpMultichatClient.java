package ch16;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpMultichatClient {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("USAGE : java TcpIpMultichatClient nickname");
            System.exit(0);
        }
        try {
            String serverIp = "127.0.0.1";
            Socket socket = new Socket(serverIp, 7777); // 서버에 접속
            System.out.println("connected server.");
            Thread sender = new Thread(new ClientSender(socket, args[0])); // 생성자로 초기화
            Thread receiver = new Thread(new ClientReceiver(socket)); // 생성자로 초기화

            sender.start();
            receiver.start(); //쓰레드 실행
        }catch (ConnectException ce){
            ce.printStackTrace();
        }catch (Exception e){}
    }
    static class ClientSender extends Thread{
        Socket socket;
        DataOutputStream out;
        String name;

        ClientSender(Socket socket, String name){
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name=name;
            }catch (Exception e){}
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if(out!=null){
                    out.writeUTF(name);
                }
                while(out!=null){
                    out.writeUTF("["+name+"]"+scanner.nextLine());
                }
            }catch (IOException e){}
        }
    }
    static class ClientReceiver extends Thread{
        Socket socket;
        DataInputStream in;

        ClientReceiver(Socket socket){
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            }catch (IOException e){}
        }

        @Override
        public void run() {
            while(in!=null){
                try {
                    System.out.println(in.readUTF());
                }catch (IOException e){}
            }
        }
    }
}
