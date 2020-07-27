package cn.ccTengx.day0221.BSDemoTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {//http://127.0.0.1:8080/E:/IdeaProject/0202-code/web/index.html
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8080);
        while(true){
            Socket socket=ss.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
        /*int len=0;
        byte []bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }*/
                        BufferedReader bR = new BufferedReader(new InputStreamReader(is));
                        String str = bR.readLine();
                        String[] strings = str.split(" ");
                        String astr = strings[1].substring(1);

                        FileInputStream fis = new FileInputStream(astr);
                        OutputStream os = socket.getOutputStream();
                        // 写入HTTP协议响应头,固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        // 必须要写入空行,否则浏览器不解析
                        os.write("\r\n".getBytes());
                        //一读一写复制文件,把服务读取的html文件回写到客户端
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }
                        fis.close();
                        socket.close();
                    }catch (IOException E){
                        System.out.println(E);
                    }
                }
            }).start();
        }
    }
}
