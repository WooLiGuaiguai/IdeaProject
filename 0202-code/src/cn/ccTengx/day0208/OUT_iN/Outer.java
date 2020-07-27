package cn.ccTengx.day0208.OUT_iN;

public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.ss();//这里想调用内部类，所以只能在该方法里面创建新对象
    }
    public void ss(){
        class Inner{//局部内部类意味着 出了这个方法就不能再继续使用了
            int num=10;
            public void iss(){
                System.out.println("num的具体值是："+num);
            }
        }
        //创建一个内部类对象  调用它的方法
        Inner inner=new Inner();
        inner.iss();
    }
}
