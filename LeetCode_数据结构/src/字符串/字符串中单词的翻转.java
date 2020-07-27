package 字符串;
/*
s = "I am a student"
Return "student a am I"
将每个单词翻转，然后将整个字符串翻转。
*/public class 字符串中单词的翻转 {
    public static void main(String[] args) {
        String str="I am a student";
        System.out.println(reverse_String(str));
    }
    public static String reverse_String(String str){
        if(str.equals("")){
            return "";
        }
        char []chars=str.toCharArray();
        int n=chars.length;
        int start=0;int end=0;//定义两个指针 记录翻转的单词的始末位置
        while(end<=n){//遍历将每个单词进行翻转了
            if(end==n||chars[end]==' '){
                reverse_str(chars,start,end-1);
                start=end+1;
            }
            end=end+1;
        }
        reverse_str(chars,0,n-1);
        return String.valueOf(chars);
    }
    public static void reverse_str(char []s,int l,int r){
        int n=s.length;
        if(n<=1){
            return ;
        }
        while(l<r){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}
