package 字符串;
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class 替换空格 {
    public static String replaceSpace(StringBuffer str){
        if (str==null){
            return null;
        }
        String string=str.toString();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<string.length();i++){
            if (string.charAt(i) == ' ') {
                sb.append("%20");
            }else{
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        StringBuffer str1=new StringBuffer("we are ");
        StringBuffer str2=new StringBuffer(" are ");
        StringBuffer str3=new StringBuffer("  ");
        StringBuffer str4=new StringBuffer("");
        System.out.println(replaceSpace(str1));
        System.out.println(replaceSpace(str2));
        System.out.println(replaceSpace(str3));
        System.out.println(replaceSpace(str4));
    }
}
