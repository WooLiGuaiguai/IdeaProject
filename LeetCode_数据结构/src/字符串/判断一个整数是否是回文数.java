package 字符串;
/*要求不能使用额外空间，也就不能将整数转换为字符串进行判断。
将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。*/
public class 判断一个整数是否是回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(250));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(200));
    }
    public static boolean isPalindrome(int x){
        if(x==0){
            return true;
        }
        if(x<0||x%10==0){//这里后面一项表示要排除1000这种情况。  如果最后一位是0，那么第一位也必须是0才能使得回文条件成立，这时候只有0
            return false;
        }
        int right=0;
        while(x>right){
            right=right*10+x%10;//将right之前的值向前进一位，然后取出x最右侧的数字添加到后面
            x=x/10;//将这个数字从x中去掉 并使得x向右移动
        }
        return x==right||x==right/10;
    }
}
