public class test2_son extends test2{
    protected int z;
    int num=200;
    public test2_son(int x,int y,int z){
        super(x,y);
        this.z=z;
    }

    @Override
    public void func() {
        super.func();
        System.out.println("儿子的func方法调用");
    }

    public static void main(String[] args) {
        test2 f=new test2_son(1,2,3);
        f.func();
        System.out.println(f.num);
    }
}
