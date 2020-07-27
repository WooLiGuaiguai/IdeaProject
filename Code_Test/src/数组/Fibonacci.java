package 数组;

public class Fibonacci {
    //F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
    public static void main(String[] args) {
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci2(4));
    }
    //普通斐波那契
    public static int Fibonacci(int n){
        int []F=new int[n];
        F[0]=1;
        F[1]=1;
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{//第1项是F[0]  第n项F[n-1]
            for(int i=2;i<n;i++){
                F[i]=F[i-1]+F[i-2];
            }
            return F[n-1];
        }
    }
    //升级版递归菲波那切数列
    //F[n]=F[n-1]+F[n-2]
    public static int Fibonacci2(int target){
        //target=1  1种  target=2 2种
        if(target<=0){
            return 0;
        }else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else{
            return Fibonacci2(target-1)+Fibonacci2(target-2);
        }
    }
}
