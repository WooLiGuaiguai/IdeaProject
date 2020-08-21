package 字符串;
//从字符串中找出一个最长的不包含重复数字的子字符串的长度。例如在字符串中arabcacfr",最长非重复子字符串为“rabc”或”acfr”，长度为4.
public class 最长无重复字母子串 {
    public static String FindStuStr(String str){
        int []positions=new int[26];//标记每个字母上次出现的位置
        int maxLen=1;//标记字符串最大长度
        int maxIndex=0;//标记最大字符串最后一位下标
        int []lines=new int[str.length()];//标记以当前字母结尾的非重复子串的最大长度
        //首先处理第一个字母
        positions[str.charAt(0)-'a']=0;
        lines[0]=1;
        for(int i=1;i<str.length();i++){
            int preposition=positions[str.charAt(i)-'a'];
            //判断是不是第一次出现
            if (preposition>=0){//出现过
                //判断当前字母的前一次出现位置是否在前一个字母的最短子串区间
                if(i-preposition>lines[i-1]){//不在---a....b....b a
                    lines[i]=lines[i-1]+1;
                }else{                       //b...a...b a
                    lines[i]=i-preposition;
                }
            }else{//没有出现过
                lines[i]=lines[i-1]+1;
            }
            positions[str.charAt(i)-'a']=i;
            if(maxLen<lines[i]){
                maxLen=lines[i];
                maxIndex=i;
            }
        }
       return str.substring(maxIndex-lines[maxIndex+1],maxIndex+1);
        //return maxLen;
    }

    public static void main(String[] args) {
        String str="arabcacfrrrr";
        System.out.println(FindStuStr(str));
    }
}
