package homework;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	 public static void main(String[] args) {
		 
	        try {
	            //�����ͻ���Socket��ָ���������˿ںź͵�ַ
	            Socket socket = new Socket("127.0.0.1",3333);
	            //��ȡ�����,�������������Ϣ
	            OutputStream os = socket.getOutputStream(); //�ֽ������
	            PrintWriter pw  = new PrintWriter(os); //���������װΪ��ӡ��
	            pw.write("Hello World!");
	            pw.flush();
	            socket.shutdownOutput(); //�ر������
	 
	            pw.close();
	            os.close();
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
