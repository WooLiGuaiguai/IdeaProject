package cn.ccTengx.day0219;

public class PRAtice {
    public static void main(String[] args) {
        char []chars={'2','2','2','.','6'};
        System.out.println(isNumeric(chars));
    }
    public static boolean isNumeric(char[] str) {
        if(str.length==0||str==null){
            return false;
        }
        String string=new String(str);
        return string.matches("[+-]?(\\d*)(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
