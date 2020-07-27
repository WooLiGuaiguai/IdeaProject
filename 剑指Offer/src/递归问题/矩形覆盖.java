package 递归问题;
//（1）1 * 3方块 覆 盖3*n区域：f(n) = f(n-1) + f(n - 3)， (n > 3)
//（2） 1 *4 方块 覆 盖4*n区域：f(n) = f(n-1) + f(n - 4)，(n > 4)
//更一般的结论，如果用1*m的方块覆盖m*n区域，递推关系式为f(n) = f(n-1) + f(n-m)，(n > m)。
public class 矩形覆盖 {
    public static void main(String[] args) {

    }

    public static int RectCover(int target) {
        if(target==0||target==1||target==2){
            return target;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
    public int RectCoverII (int target) {
        int a=1,b=2,c=0;
        if(target==0||target==1||target==2){
            return target;
        }else{
            for(int i=3;i<=target;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }
    }

}
