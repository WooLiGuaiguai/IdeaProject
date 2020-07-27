package cn.ccTengx.day0205;

public class StudentTest {
    public static void main(String[] args) {
        Student student1=new Student();
        student1.classs="axiba";
        System.out.println("one的教室"+student1.getClasss()+" one的学号"+student1.getIcounter());
        Student student2=new Student();
        //student1.classs="axiiiiiiba";
        System.out.println("two的教室"+student1.getClasss()+" two的学号"+student1.getIcounter());

        System.out.println(Math.ceil(-25.6));
        System.out.println(Math.floor(-25.6));
    }
}
