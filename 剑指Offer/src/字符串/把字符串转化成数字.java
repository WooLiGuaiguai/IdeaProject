package 字符串;

public class 把字符串转化成数字 {
    public static int StrToInt(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        //判断是正数还是负数
        boolean flag=(str.charAt(0)=='-') ? true : false;
        char []chars=str.toCharArray();
        int result=0;//用来保存最后的结果
        for(int i=0;i<chars.length;i++){
            if(i==0 && (chars[i]=='+'||chars[i]=='-')){
                continue;
            }
            if(chars[i]>'9'||chars[i]<'0'){
                return '0';
            }
            result=result*10+(chars[i]-'0');
        }
        return flag ? -result :result;
    }
    public static void main(String[] args) {
        System.out.println(StrToInt("-156"));
        System.out.println(StrToInt("165"));
    }
}
