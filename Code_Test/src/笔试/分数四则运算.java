package 笔试;

import java.util.Scanner;

class BiShi {
    int num1;//分子1
    int den1;//分母1
    String operator;//操作符
    int num2;//分子2
    int den2;//分母2
    public BiShi(int num1,int den1,String operator,int num2,int den2){
        this.num1=num1;
        this.den1=den1;
        this.operator=operator;
        this.num2=num2;
        this.den2=den2;
    }
    public  void addition(){
        int x=num1*den2+num2*den1;
        int y=den1*den2;
        gcd(x,y);//计算
    }
    public  void subtraction(){
        int x=num1*den2-num2*den1;
        int y=den1*den2;
        gcd(x,y);
    }
    public  void multiplication(){
        int x=num1 *num2;
        int y=den1*den2;
        gcd(x,y);
    }
    public  void division(){
        int x=num1*den2;
        int y=den1*num2;
        gcd(x,y);
    }
    public int gcd(int m,int n){
        int r,t,u,w;
        //先存储分子分母初始值
        t=m;
        w=n;
        //求最大公因数
        while(n!=0){
            r=m%n;
            m=n;
            n=r;
        }
        //循环结束 m最大公因数
        u=m;
        t=t/u;
        w=w/u;
        if(t==1 &&w==1){
            System.out.println("1");
        }else if(t==0 && w!=0){
            System.out.println("0");
        }else{
            System.out.println(t+"/"+w);
        }
        return 0;
    }
}
 class Test2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str=in.nextLine();
        if(str.length()<9){
            System.out.println("输入错误");
        }
        char []chars=str.toCharArray();
        //提取数字
        int a=Integer.parseInt(String.valueOf(chars[0]));
        int b=Integer.parseInt(String.valueOf(chars[2]));
        String mm=String.valueOf(chars[3]);//空格
        String o=String.valueOf(chars[4]);
        String nn=String.valueOf(chars[5]);
        int c=Integer.parseInt(String.valueOf(chars[6]));
        int d=Integer.parseInt(String.valueOf(chars[8]));

        //判断
        if(a<0||a>9||b<0||b>9||c<0||c>9||d<0||d>9){
            System.out.println("输入错误");
        }
        if(b==0 ||d==0){
            System.out.println("输入错误");
        }
        if(!o.equals("+") &&!o.equals("-")&&!o.equals("*")&&!o.equals("/")){
            System.out.println("输入错误");
        }
        if(!mm.equals(" ") || !nn.equals(" ")){
            System.out.println("输入错误");
        }
        //构造
        BiShi bs=new BiShi(a,b,o,c,d);
        if(o.equals("+")){
            bs.addition();
        }else if(o.equals("-")){
            bs.subtraction();
        }else if(o.equals("*")){
            bs.multiplication();
        }else if(o.equals("/")){
            bs.division();
        }
    }
}