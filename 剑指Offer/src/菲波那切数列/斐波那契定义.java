package 菲波那切数列;


public class 斐波那契定义 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci2(5));
        System.out.println(sum(5));
    }
    //求斐波那契数列前n项和
    public static int sum(int n){
        int a=1,b=1,c=0;
        if(n==0||n==1||n==2){
            return n;
        }else {
            int sum=2;
            for(int i=3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
                sum=sum+c;
            }
            return sum;
        }
    }
    public static int Fibonacci2(int n){
        int a=1,b=1,result=0;
        if(n==0||n==1){
            return n;
        }else if(n==2){
            return 1;
        }else{
            for(int i=3;i<=n;i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }
    }
    public static int Fibonacci(int n){
        if(n==0||n==1){
            return n;
        }
        int []F=new int[n+1];
        F[0]=0;
        F[1]=1;
        for(int i=2;i<=n;i++){
            F[i]=F[i-1]+F[i-2];
        }
        return F[n];
    }
}
