package cn.ccTengx.day0205;

public class Student {
    static String classs;//可以在生成对象之后进行赋值
    private static int icounter=0;//学号计数器，每当new一个新对象时 ++
    public Student(){
        icounter++;
    }

    public static String getClasss() {
        return classs;
    }

    public static void setClasss(String classs) {
        Student.classs = classs;
    }

    public static int getIcounter() {
        return icounter;
    }

    public static void setIcounter(int icounter) {
        Student.icounter = icounter;
    }
}
