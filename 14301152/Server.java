package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss;  
    
    private InputStreamReader inputStreamReader;   
      
    private BufferedReader bufferedReader;  
      
    public static void main(String[] args) {
    		 
            try {
                //1������һ����������Socket,��ServerSocket, ָ���󶨵Ķ˿ڣ��������˶˿�
                ServerSocket serverSocket = new ServerSocket(3333);
                Socket socket = null;
                //��¼�ͻ��˵�����
               // int count = 0;
                System.out.println("***�����������������ȴ��ͻ��˵�����***");
                //ѭ�������ȴ��ͻ��˵�����
                while (true){
                    //����accept()������ʼ�������ȴ��ͻ��˵�����
                    socket = serverSocket.accept();
                    //����һ���µ��߳�
                    bkSequence serverThread = new bkSequence(socket);
                    //�����߳�
                    serverThread.run();
     
                    //count++; //ͳ�ƿͻ��˵�����
                    //System.out.println("�ͻ��˵�����: " + count);
                    //InetAddress address = socket.getInetAddress();
                    //System.out.println("��ǰ�ͻ��˵�IP �� " + address.getHostAddress());
                }
     
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
