package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class bkSequence {
	//�ͱ��߳���ص�Socket
    Socket socket = null;
    public bkSequence(Socket socket){
        this.socket = socket;
    }
 
    //�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
    public void run(){
 
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
 
        try {
 
            //��ȡһ��������������ȡ�ͻ��˵���Ϣ
            is = socket.getInputStream();
            isr = new InputStreamReader(is); //���ֽ���ת��Ϊ�ַ���
            br = new BufferedReader(isr); //��ӻ���
            String info = null;
            //ѭ����ȡ����
            while ((info = br.readLine()) != null){
            	for(int i=info.length()-1;i>=0;i--){
                System.out.print(info.charAt(i));
            		}
            	}
 
            socket.shutdownInput(); //�ر�������
 
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
