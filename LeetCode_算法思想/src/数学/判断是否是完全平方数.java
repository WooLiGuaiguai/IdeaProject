package 数学;
//平方序列：1,4,9,16,..
//间隔：3,5,7,...
//间隔为等差数列，使用这个特性可以得到从 1 开始的平方序列。
public class 判断是否是完全平方数 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(17));
    }
    public static boolean isPerfectSquare(int num) {
        int subNum=1;//差值
        while(num>0){
            num=num-subNum;
            subNum=subNum+2;
        }
        //假如初始17--16--13--8--1--(-8)  初始16--15--11--7--0
        return num==0;
    }
}
