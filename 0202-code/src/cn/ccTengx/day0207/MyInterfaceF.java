package cn.ccTengx.day0207;

public class MyInterfaceF {
    static int num=10;
     private String name;
    public MyInterfaceF(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("父类"+num);
    }
    public  void methodDefaut3(){
        System.out.println("this is a 父类方法");
        //method_p();
    }
}
