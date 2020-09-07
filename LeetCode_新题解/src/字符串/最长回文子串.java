package 字符串;
//给定一个字符串 s，找到 s 中最长的回文子串
//使用马拉车方法
//1. 对原始字符串进行预处理   2.计算辅助数组 数组元素就是以该index为中心的回文串长度
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }
        String str=addBoundaries(s,'#');//将原字符串添加分隔符
        int slen=2*len+1;//新的字符串总长度
        int maxlen=1;
        int start=0;//当前maxlen子串的起始坐标
        for(int i=0;i<slen;i++){
            int curlen=centerSpread(str,i);//以当前下标为中心的回文串长度
            if(curlen>maxlen){
                maxlen=curlen;
                start=(i-maxlen)/2;//将它在str中的下标转化成在原字符串的下标
            }
        }
        return s.substring(start,start+maxlen);
    }
    public int centerSpread(String s,int center){//center是中心下标
        int len=s.length();
        int i=center-1;
        int j=center+1;
        int step=0;
        while(i>=0 && j<=len-1 && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            step++;
        }
        return step;
    }
    public String addBoundaries(String s,char divide){
        int len=s.length();
        if(len==0){
            return "";
        }
        //public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
        if(s.indexOf(divide)!=-1){
            throw new IllegalArgumentException("分隔符已经存在在");
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<len;i++){
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }
}
