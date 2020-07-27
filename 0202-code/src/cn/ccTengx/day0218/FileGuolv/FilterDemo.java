package cn.ccTengx.day0218.FileGuolv;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;


public class FilterDemo {
    public static void main(String[] args) {
        File file=new File("E:\\IdeaProject\\0202-code\\src\\cn\\ccTengx");
        /*FileBL(file);
        System.out.println("===========");
        FileBL2(file);
        System.out.println("===========");
        getAllFile(file);*/
        System.out.println("==================================");
        show1(file);
    }
    public static  void show(File file){
        File []files=file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".txt");
            }
        });
        for (File f : files) {
            if(f.isDirectory()){
                show(f);
            }else{
                System.out.println(f);
            }
        }
    }
    public static  void show1(File file){
        File []files=file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".txt");
            }
        });
        for (File f : files) {
            if(f.isDirectory()){
                show1(f);
            }else{
                System.out.println(f);
            }
        }
    }
    public static void FileBL2(File file){//接口实现类自己定义 并重写accept方法
        File []files=file.listFiles(new FilterImpl());
        for (File f : files) {
            if(f.isDirectory()){
                FileBL2(f);
            }else{
                System.out.println(f);
            }
        }
    }
    public static void getAllFile(File dir) {
        //System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles();
        for (File f : files) {
            //对遍历得到的File对象f进行判断,判断是否是文件夹
            if (f.isDirectory()) {
                //f是一个文件夹,则继续遍历这个文件夹
                //我们发现getAllFile方法就是传递文件夹,遍历文件夹的方法
                //所以直接调用getAllFile方法即可:递归(自己调用自己)
                getAllFile(f);
            } else {
                if (f.getName().toLowerCase().endsWith(".txt")) {
                    System.out.println(f);
                }
            }
        }
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
