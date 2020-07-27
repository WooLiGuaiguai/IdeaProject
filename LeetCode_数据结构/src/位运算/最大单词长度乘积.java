package 位运算;

public class 最大单词长度乘积 {
    public static void main(String[] args) {
        String []strs={"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(strs));
    }
    public static int maxProduct(String[] words) {
        int n=words.length;
        int []val=new int[n];
        for(int i=0;i<n;i++){//遍历每个字符串
            for(char c:words[i].toCharArray()){//遍历字符串中的每个字符
                val[i]|=1<<(c-'a');//这样来看abc这个字符串的val就是111   efg的val是111000
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((val[i]&val[j])==0){//说明没有一个字母相同
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}
