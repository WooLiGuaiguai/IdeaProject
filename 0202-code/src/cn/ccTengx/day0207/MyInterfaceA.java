package cn.ccTengx.day0207;

public interface MyInterfaceA {
    public static final int num=10;
    public abstract void methodDefaut1();
    public default void methodDefaut2(){
        System.out.println("this is a 默认方法，too");
        //method_p();
    }
    /*private void method_p(){
        System.out.println("this is a 私有化方法，too");
    }*/
}
