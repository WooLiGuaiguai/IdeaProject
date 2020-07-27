package 排序.Definition;

public class 类变量传值 {
    //定义类变量
    static int a = 3;
    static int b = 2;
    public static void main(String[] args) {
        类变量传值 ts = new 类变量传值();
        System.out.println("before swap "+"a的值="+ts.a+" b的值="+ts.b);
        ts.swap(ts);
        System.out.println("after swap "+"a的值="+ts.a+" b的值="+ts.b);
    }
    //改变的是类变量的值
    private static void swap(类变量传值 ts)
    {
        int temp;
        temp = ts.a;
        ts.a = ts.b;
        ts.b = temp;
    }
}
