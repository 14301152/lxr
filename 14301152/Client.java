package homework;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	 public static void main(String[] args) {
		 
	        try {
	            //创建客户端Socket，指定服务器端口号和地址
	            Socket socket = new Socket("127.0.0.1",3333);
	            //获取输出流,向服务器发送信息
	            OutputStream os = socket.getOutputStream(); //字节输出流
	            PrintWriter pw  = new PrintWriter(os); //将输出流包装为打印流
	            pw.write("Hello World!");
	            pw.flush();
	            socket.shutdownOutput(); //关闭输出流
	 
	            pw.close();
	            os.close();
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
