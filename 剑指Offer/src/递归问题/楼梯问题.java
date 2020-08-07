package 递归问题;

public class 楼梯问题 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(5));
        System.out.println(JumpFloorII(10));
        System.out.println(JumpFloorIII(10));
    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
    public static int JumpFloor(int target) {
        int fir=1,sec=2,thi=0;
        if(target==1||target==2){
            return target;
        }else {
            for(int i=3;i<=target;i++){
                thi=fir+sec;
                fir=sec;
                sec=thi;
            }
            return thi;
        }
    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static int JumpFloorII(int target){
        if(target==1||target==2){
            return target;
        }else{
            return JumpFloorII(target-1)*2;
        }
    }
    public static int JumpFloorIII(int target){
        if(target==1||target==2){
            return target;
        }else{
            int []Jumps=new int[target+1];
            Jumps[0]=1;
            Jumps[1]=1;
            Jumps[2]=2;
            for(int i=3;i<=target;i++){
                Jumps[i]=0;
                for(int j=1;j<i;j++){
                    Jumps[i]+=Jumps[j];
                }
            }
            return Jumps[target];
        }
    }
}
