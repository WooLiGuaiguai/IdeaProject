package cn.ccTengx.day0208.Niming;

public class DemoMain {
    public static void main(String[] args) {
        // 使用匿名内部类，但不是匿名对象，对象名称就叫obj
        MyInterface obj=new MyInterface() {
            @Override
            public void show() {
                System.out.println("匿名内部类的使用--AAA");
            }
            @Override
            public void show2() {
                System.out.println("匿名内部类的使用--BBB");
            }
        };
        obj.show();
        obj.show2();
        System.out.println("================================");
        //使用了匿名内部类，而且省略了对象名称，也是匿名对象,只能调用一个方法
        new MyInterface() {
            @Override
            public void show() {
                System.out.println("A匿名内部类的使用--AAA");
            }
            @Override
            public void show2() {
                System.out.println("B匿名内部类的使用--BBB");
            }
        }.show();
        new MyInterface() {
            @Override
            public void show() {
                System.out.println("A匿名内部类的使用--AAA");
            }
            @Override
            public void show2() {
                System.out.println("B匿名内部类的使用--BBB");
            }
        }.show2();
    }
}
