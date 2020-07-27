package 字符串;

public class konggetihuan {
    public static void main(String[] args) {
        konggetihuan s=new konggetihuan();
        StringBuffer str1=new StringBuffer("we are ");
        StringBuffer str2=new StringBuffer(" are ");
        StringBuffer str3=new StringBuffer("  ");
        StringBuffer str4=new StringBuffer("");
        System.out.println(s.replaceSpace(str1));
        System.out.println(s.replaceSpace(str2));
        System.out.println(s.replaceSpace(str3));
        System.out.println(s.replaceSpace(str4));
    }
    public static String replaceSpace(StringBuffer str){
        if(str==null){
            return null;
        }
        StringBuffer sb=new StringBuffer();
        //字符串的长度是一个函数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
