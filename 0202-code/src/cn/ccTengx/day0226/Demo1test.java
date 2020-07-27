package cn.ccTengx.day0226;
@MyAnno3
@MyAnno(show1=1,show2 ="str",show3 = {"abc","123"},show4 = @MyAnno2,show5 = MyEnum.p1)
public class Demo1test {
    @MyAnno3
    private int a;
    @MyAnno3
    public  void show(){}
}
