package cn.ccTengx.day0215;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsExceptionTest {
    public static void main(String[] args) {

        try{
            readFile("c:\\a.xt");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.println("后续代码继续执行");
    }
    public static  void readFile(String fileName) throws IOException {
        if(!fileName.endsWith(".txt")){
            throw new FileNotFoundException("文件的后缀名不对");
        }
        if(!fileName.equals("c:\\a.txt")){
            throw new IOException("传递的文件路径不是c:\\a.txt");
        }
        System.out.println("路径没有问题,读取文件");
    }
}
