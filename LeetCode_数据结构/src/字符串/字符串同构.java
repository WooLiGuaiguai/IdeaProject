package 字符串;
/*给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
*/
public class 字符串同构 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int []schar=new int[256];
        int []tchar=new int[256];
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if(schar[sc]!=tchar[tc]){
                return false;
            }
            schar[sc]=i+1;
            tchar[tc]=i+1;//最开始的时候每个元素都是0 所以也会执行这两行
        }
        return true;
    }
}
