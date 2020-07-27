package cn.ccTengx.day0208;

/*
分类：
1.成员内部类
2.局部内部类（包含匿名内部类）
*/
//基本格式
public class body {
    int num=10;
    public class heart{
        int num=20;
        public void ss(int num){
            num=30;
            System.out.println(num);//就近原则，局部变量
            System.out.println(this.num);//内部类变量
            System.out.println(body.this.num);//外部类变量
        }
    }
}
//注意事项
//内用外，随意访问，外用内，需要内部类对象
/*
如何使用成员内部类？有两种方式：
1.间接方式：在外部类的方法中使用内部类(变量或方法)，然后main知识调用外部类方法
2.直接方式： 外部类名称.内部类名称 对象名=new 外部类名称( ).new 内部类名称( );
*/
