package cn.ccTengx.day0207;

public class DemoInterface {
    public static void main(String[] args) {
        MyInterfaceAtest myInterfaceAtest=new MyInterfaceAtest("ailigei");
       // myInterfaceAtest.methodDefaut();
        //myInterfaceAtest.methodDefaut1();
        myInterfaceAtest.methodDefaut3();
        System.out.println(MyInterfaceA.num);
        /*
        访问成员变量的两种方式
        1.直接通过对象名称访问成员变量：看等号左边是谁就优先用谁
        2.间接通过成员方法访问成员变量：看该方法属于谁，优先用谁
            子类如果覆盖重写，就用子类；否则父类
        */
        MyInterfaceF myInterfaceAtest2=new MyInterfaceAtest("ailili");
        System.out.println(myInterfaceAtest2.num);//num右侧是MyInterfaceF类型对象
        myInterfaceAtest2.show();
        /*
        成员方法的访问规则：
        new的是谁，就优先用谁
        成员变量：编译看左边，运行看左边
        成员方法：编译看左边，运行看右边
         */
        final int num;
        num=30;//正确写法
        final MyInterfaceF a1=new MyInterfaceF("gaoyuanyuan");
        //错误   a1=new MyInterfaceF("dididid");
        a1.setName("dilireba");//正确





    }
}
