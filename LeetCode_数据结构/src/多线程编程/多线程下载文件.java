package 多线程编程;

import java.net.MalformedURLException;
import java.net.URL;

public class 多线程下载文件 {
    public static void main(String[] args) {
        Thread downloadThread =null;
        for (String arg : args) {
            //创建文件下载器线程
            downloadThread=new Thread(new FileLoader(arg));
            //启动文件下载器线程
            downloadThread.start();
        }
    }
    static class FileLoader implements Runnable{
        private final String fileURL;
        public FileLoader(String fileURL){
            this.fileURL=fileURL;
        }
        @Override
        public void run() {
            String filename=fileURL.substring(fileURL.lastIndexOf('/')+1);
            try{
                URL url=new URL(fileURL);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
