package cn.ccTengx.day0207;

public class MyInterfaceAtest extends MyInterfaceF implements MyInterfaceA,MyInterfaceB {
    int num=15;

    public MyInterfaceAtest(String name) {
        super(name);
    }

    public void show(){
        System.out.println("字类"+num);
    }
    public void methodDefaut1(){
        System.out.println("重写A接口的方法");
    }
    public void methodDefaut(){
        System.out.println("重写B接口的方法");
    }
}
