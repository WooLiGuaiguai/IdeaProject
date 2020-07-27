package cn.ccTengx.day0221.DemoFileUploadUpdate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPFileUp {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream(
                "E:\\IdeaProject\\0202-code" +
                        "\\src\\cn\\ccTengx\\day0220\\1.png");
        Socket socket=new Socket("127.0.0.1",8888);
        OutputStream os=socket.getOutputStream();
        int len=0;
        while((len=fis.read())!=-1){
            os.write(len);
        }
        socket.shutdownOutput();
        InputStream is=socket.getInputStream();
        byte []bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();

    }
}
