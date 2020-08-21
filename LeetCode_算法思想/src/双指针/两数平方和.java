package 双指针;
/*给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 示例1:
 输入: 5
 输出: True
 解释: 1 * 1 + 2 * 2 = 5

 示例2:
 输入: 3
 输出: False*/
public class 两数平方和 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(3));
    }

    public static boolean judgeSquareSum(int c){
        int mid=(int)Math.sqrt(c);
        int left=0,right=mid;
        while(left<=right){
            int result=left*left+right*right;
            if(result==c){
                return true;
            }else if(result>c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}
