package cn.ccTengx.day0218.DiGui;

import java.io.File;

public class Recurision {
    public static void main(String[] args) {
        File file=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx");
        FileBL(file);
    }
    public static void FileBL(File file){
        //System.out.println(file);
        File []files=file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()){
                FileBL(files[i]);
            }else{
                String str=files[i].toString();
                if(str.endsWith(".txt"))
                {
                    System.out.println(files[i]);
                }
            }
        }
    }
}
