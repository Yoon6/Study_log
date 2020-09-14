package ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {
    HashMap clients;

    TcpIpMultichatServer(){
        clients = new HashMap(); //
        Collections.synchronizedMap(clients);
    }
    public void start(){
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("start server.");

            while(true){// 무한반복으로 계속 대기중인 상태
                socket = serverSocket.accept();
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void sendToAll(String msg){
        Iterator it = clients.keySet().iterator(); // key를 받아옴
        while(it.hasNext()){
            try {
                DataOutputStream out = (DataOutputStream)clients.get(it.next());
                out.writeUTF(msg); // Map의 value에 출력(메모리에 출력)
            }catch (IOException e){}
        }
    }

    public static void main(String[] args) {
        new TcpIpMultichatServer().start(); // 생성자 수행하고, start()수행
    }
    class ServerReceiver extends Thread{
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket){ // 소켓, 스트림
            this.socket= socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            }catch (IOException e){}
        }

        @Override
        public void run() {
            String name = "";
            try{
                name = in.readUTF();
                sendToAll("#"+name+"님이 들어오셨습니다."); // 클라이언트에 표시

                clients.put(name, out);
                System.out.println("현재 서버접속자 수는 "+clients.size()+"입니다."); // 서버에 표시
                while (in!=null){ // OutputStream이 이용자정보이기 때문에 이용자가 없을 때 까지 반복
                    sendToAll(in.readUTF());
                }
            }catch (IOException e){
            }finally {
                sendToAll("#"+name+"님이 나가셨습니다."); // 클라이언트에
                clients.remove(name);
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]에서 접속을 종료하였습니다."); // 서버에 표시
                System.out.println("현재 서버접속자 수는 "+clients.size()+"입니다."); // 클라이언트에 표시
            }
        }
    }
}
