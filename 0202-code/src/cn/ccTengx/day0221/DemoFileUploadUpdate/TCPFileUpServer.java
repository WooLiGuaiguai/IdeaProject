package cn.ccTengx.day0221.DemoFileUploadUpdate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPFileUpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8888);
        while(true){
            Socket socket=ss.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        String fileName = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
                        File file = new File("E:\\IdeaProject\\0202-code" +
                                "\\src\\cn\\ccTengx\\day0221\\TCPFileTest");
                        String name = "itcast" + System.currentTimeMillis() + new Random().nextInt(99999);
                        FileOutputStream fos = new FileOutputStream(file + "\\" + name + ".png");
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        OutputStream os = socket.getOutputStream();
                        os.write("已经收到 谢谢".getBytes());
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }).start();
        }
    }
}
