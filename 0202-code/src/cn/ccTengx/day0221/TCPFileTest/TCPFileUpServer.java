package cn.ccTengx.day0221.TCPFileTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8888);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        FileOutputStream fos=new FileOutputStream(
                "E:\\IdeaProject\\0202-code" +
                        "\\src\\cn\\ccTengx\\day0221\\TCPFileTest\\3.png");
        int len=0;
        byte []bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        OutputStream os=socket.getOutputStream();
        os.write("已经收到 谢谢".getBytes());
        fos.close();
        socket.close();
        ss.close();
    }
}
