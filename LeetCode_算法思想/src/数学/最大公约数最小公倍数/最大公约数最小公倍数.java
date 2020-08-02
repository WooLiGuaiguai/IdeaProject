package 数学.最大公约数最小公倍数;

public class 最大公约数最小公倍数 {
    public static void main(String[] args) {
        System.out.println(gcd(5,15));
        System.out.println(lcm(5,15));
        System.out.println(gcd2(50,20));
    }
    public static int gcd(int a, int b){
        return b==0?a:gcd(a,++b%a);
    }
    //最小公倍数
    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
    //使用位操作和减法求解最大公约数  对于 a 和 b 的最大公约数 f(a, b)，有：
    //如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);    如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
    //如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);      如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);
    //乘 2 和除 2 都可以转换为移位操作。
    public static int gcd2(int a,int b){
        if(a<b){
            return gcd2(b,a);
        }
        if(b==0){
            return a;
        }
        if(isEven(a) && isEven(b)){
            return 2*gcd2(a>>1,b>>1);
        }else if(isEven(a) && !isEven(b)){
            return gcd2(a>>1,b);
        }else if(!isEven(a) && isEven(b)){
            return gcd2(a,b>>1);
        }else{
            return gcd2(b,a-b);
        }
    }
    public static boolean isEven(int num){//判断是否是偶数
        if(num%2==0){
            return true;
        }else{
            return false;
        }
    }
}
