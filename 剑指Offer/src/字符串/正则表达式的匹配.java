package 字符串;
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。
//模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
//例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
public class 正则表达式的匹配 {
    public boolean match(char[] str, char[] pattern){
        return matchTwo(str,0,str.length,pattern,0,pattern.length);
    }
    public  boolean matchTwo(char[]str,int s,int length1,char []pattern,int p,int length2){
        //s和p分别是两个字符串的移动的坐标指针，p串是模式串
        if(s==length1 && p==length2){//都匹配到最后一位的后面一个  匹配成功
            return true;
        }
        if(s!=length1 && p==length2){//
            return false;
        }
        if(s==length1 && p!=length2){
            while(p!=length2){
                if(pattern[p]!='*' && ((p+1==length2)||pattern[p+1]!='*')){
                    //模式串还剩下 单个不是'*'的字符 或 有两个以上且后两个都不是'*' 的时候匹配失败
                    return  false;
                }
                p++;
            }
            return true;
        }
        if(p+1==length2){//模式串最后一位
            if(str[s]==pattern[p]||pattern[p]=='.')
                return matchTwo(str, s+1, length1, pattern, p+1, length2);
            else {
                return false;
            }
        }
        if((str[s]==pattern[p]||pattern[p]=='.')&&pattern[p+1]!='*')
            return matchTwo(str, s+1, length1, pattern, p+1, length2);
        if((str[s]==pattern[p]||pattern[p]=='.')&&pattern[p+1]=='*')
            return matchTwo(str, s, length1, pattern, p+2, length2)||matchTwo(str, s+1, length1, pattern, p, length2);
        if(pattern[p+1]=='*')
            return matchTwo(str, s, length1, pattern, p+2, length2);
        return false;
    }

    public static void main(String[] args) {
        正则表达式的匹配 a=new 正则表达式的匹配();
        boolean flag=a.match("abcaaa".toCharArray(),"abca*".toCharArray());
        System.out.println(flag);
    }
}
