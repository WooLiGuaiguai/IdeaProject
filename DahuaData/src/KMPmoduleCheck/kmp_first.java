package KMPmoduleCheck;

public class kmp_first {
    public static void main(String[] args) {
        String str1="ababcabcacbab";
        String T1="abc";
        String str="aaaabcde";
        String T="aaaaax";
        System.out.println(INDEX_KMP(str1,T1,4));
        System.out.println(INDEX_KMP(str,T,0));

    }
    //      j= 1 2 3 4 5 6 7 8 9
    //next[j]= 0 1 x x x x x x x
    public static int[] get_next(String str){
        int i,j;//i表示当前字符串长度  j用来遍历子串数组str
        int []next=new int[str.length()+1];
        i=0;j=-1;
        next[0]=-1;
        while(i<str.length())//字符第一位 表示长度
        {
            if(j==-1||str.charAt(i)==str.charAt(j)){
                j++;
                i++;
                next[i]=j;
            }else{
                j=next[j];
            }
        }
        return next;
    }
    //KMP
    public static int INDEX_KMP(String str,String T,int pos){//要求使pos下标之后能否找到匹配字符串
        int i=pos;//i是主串坐标
        int j=-1;//子串坐标
        int [] next=get_next(T);
        while(i<str.length()&&j<T.length()){
            if(j==-1||str.charAt(i)==T.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        if(j==T.length()){
            return i-j;
        }else{
            return -1;
        }
    }

}
