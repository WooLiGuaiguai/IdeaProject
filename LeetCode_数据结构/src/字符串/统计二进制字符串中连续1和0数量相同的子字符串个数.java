package 字符串;
/*给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
重复出现的子串要计算它们出现的次数。*/
public class 统计二进制字符串中连续1和0数量相同的子字符串个数 {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
    public static int countBinarySubstrings(String s){
        int prelen=0;//因为要求0 1相同的需要连续，所以保存前面这个连续相同串的长度
        int curlen=1;//遍历的时候从i=1开始 所以先默认长度为1
        int count=0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                curlen++;
            }else{
                prelen=curlen;
                curlen=1;
            }

            if(prelen>=curlen){
                count++;
            }
        }
        return count;
    }
    public static int countBinarySubstrings1(String s) {//这个是0 1不连续的相同数量的子串个数
        if(s.length()<=1){
            return 0;
        }
        int []arr=new int[2];
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                arr[s.charAt(j)-48]++;
                if(arr[0]==arr[1]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
