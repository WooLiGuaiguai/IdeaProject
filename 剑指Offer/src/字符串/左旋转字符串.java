package 字符串;

public class 左旋转字符串 {
    public static String LeftRotateString(String str,int n){
        if(str==null||str.length()<=n){
            return str;
        }
        char []chars=str.toCharArray();
        reverse(chars,0,str.length()-1);
        reverse(chars,0,str.length()-n-1);
        reverse(chars,str.length()-n,str.length()-1);
        return new String(chars);
    }
    //翻转句子
    public static String ReverseSentence(String str) {
        char[] chars=str.toCharArray();
        int length=str.length();
        int start=0,end=0;
        while(end<=length){
            if(end==length || chars[end]==' '){//end==length的时候表示遍历到末尾，直接对这个单词进行操作
                reverse(chars,start,end-1);
                start=end+1;
            }
            end++;
        }
        reverse(chars,0,length-1);
        return new String(chars);
    }
    public static void reverse(char []chars,int start,int end){
        while(start<end){
            swap(chars,start,end);
            start++;
            end--;
        }
    }
    public static void swap(char []chars,int left,int right){
        char temp=chars[left];
        chars[left]=chars[right];
        chars[right]=temp;
    }

    public static void main(String[] args) {
        String str="abcde12345ABCDE";
        System.out.println(LeftRotateString(str,6));

        String str2="I am a student";
        System.out.println(ReverseSentence(str2));
    }
}
