package 字符串;

public class 回文子串个数 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
    private static int count=0;
    public static int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            extendSubString(s,i,i);//起始的位数是一位,每次增加之后都是奇数个
            extendSubString(s,i,i+1);
        }
        return count;
    }
    public static void extendSubString(String s,int start,int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
    }
}
