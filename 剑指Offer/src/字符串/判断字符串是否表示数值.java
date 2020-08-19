package 字符串;
//[]  ： 字符集合
//()  ： 分组
//?   ： 重复 0 ~ 1 次
//+   ： 重复 1 ~ n 次
//*   ： 重复 0 ~ n 次
//.   ： 任意字符
//\\. ： 转义后的 .
//\\d ： 数字
public class 判断字符串是否表示数值 {
    public boolean isNumeric(char[] str){
        if(str==null||str.length==0){
            return false;
        }
        //-.123也是数字  所以第一个\\d后面是*
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        判断字符串是否表示数值 a =new 判断字符串是否表示数值();
        System.out.println(a.isNumeric("-.123".toCharArray()));
        System.out.println(a.isNumeric("+10.1212E+10".toCharArray()));
        System.out.println(a.isNumeric("-10.1212E10".toCharArray()));
        System.out.println(a.isNumeric(".12e+10".toCharArray()));
    }
}
