package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class bkSequence {
	//和本线程相关的Socket
    Socket socket = null;
    public bkSequence(Socket socket){
        this.socket = socket;
    }
 
    //线程执行的操作，响应客户端的请求
    public void run(){
 
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
 
        try {
 
            //获取一个输入流，并读取客户端的信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is); //将字节流转化为字符流
            br = new BufferedReader(isr); //添加缓冲
            String info = null;
            //循环读取数据
            while ((info = br.readLine()) != null){
            	for(int i=info.length()-1;i>=0;i--){
                System.out.print(info.charAt(i));
            		}
            	}
 
            socket.shutdownInput(); //关闭输入流
 
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
 
 
                try {
                    if (is != null)
                        is.close();
                    if (isr != null)
                        isr.close();
                    if (br != null)
                        br.close();
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
 
                }
         }
    }
}
