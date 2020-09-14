package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable{
    ServerSocket serverSocket;
    Thread[] threadArr;
    public static void main(String[] args) {
        // 5개의 쓰레드를 생성하는 서버를 생성한다.
        TcpIpServer4 server4 = new TcpIpServer4(5);

        server4.start();
    }
    public TcpIpServer4(int num){
        try {
            // 서버소켓을 생성해서 7777번 포트와 결합(bind)시킨다.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"서버가 준비되었습니다.");

            threadArr = new Thread[num];
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        for(int i=0; i<threadArr.length;i++){
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(getTime()+"연결요청을 기다립니다.");
                // 서버소켓은 클라이언트의 연결 요청이 올 때까지 실행을 멈추고 계속 기다린다.
                // 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+socket.getInetAddress()+"로 부터 연결요철이 들어왔습니다.");

                // 소켓의 출력스트림을 얻는다.
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                // 원격 소켓(remote socket)에 데이터를 보낸다.
                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime()+"데이터를 전송했습니다.");
                // 스트림과 소켓을 닫아준다.
                dos.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static String getTime(){
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date())+name;
    }
}
