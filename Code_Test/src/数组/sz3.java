package 数组;
/*本题同样可以使用双指针得到两个数，使其平方和为 target。
本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。
设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。*/
public class sz3 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }
    public static boolean judgeSquareSum(int target){
        if(target<0){
            return false;
        }
        int i=0;
        int j=(int) Math.sqrt(target);
        while(i<=j){//允许相同
            int sum=i*i+j*j;
            if(sum==target){
                System.out.println(i+" "+j);
                return true;
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
