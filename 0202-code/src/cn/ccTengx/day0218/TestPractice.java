package cn.ccTengx.day0218;

public class TestPractice {
    public static void main(String[] args) {
        /*与运算符用符号“&”表示，其使用规律如下：
          只有对应的两个二进制位均为1时，结果才为1。例如，9&5，即00001001&00000101=00000001
          或运算符用符号“|”表示，其运算规律如下：
          只要对应的两个二进制位有一个为1，结果就为1,否则就为0，例如9|5，即00001001|00000101=00001101。
          异或运算符是用符号“^”表示的，其运算规律是：
          两个操作数的位中，位相同则结果为0，不同则结果为1。

          两个二进制相加 如果不考虑进位       等价于  异或操作
                         如果考虑得到进位值   等价于  做与操作，再向左移一位*/
        /*System.out.println(Integer.toBinaryString(5^7));//5是101  7是111 输出010
        System.out.println(Integer.toBinaryString((5&7)<<1));//1010 进位是10
        int []a=new int[10];
        System.out.println(a.length);*/
        //测试数据
        /*System.out.println(StrToInt("+2147483647"));
        System.out.println(StrToInt("-2147483647"));
        System.out.println(StrToInt("+0"));
        System.out.println(StrToInt("01+7403647"));
        System.out.println(StrToInt("-2147483649"));
        System.out.println(StrToInt(""));
        System.out.println(StrToInt("-2147483648"));
        System.out.println(Integer.MIN_VALUE);*/
        int []a={2, 3, 1, 0, 2, 5};
        int []b=new int[1];
        duplicate(a,6,b);
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication){
        if(numbers==null||length<=0){
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }
    public static void swap(int []num,int a,int b){
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
    public static int StrToInt1(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9')                /* 非法输入 */
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }

    public static int StrToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        char []chars=str.toCharArray();
        boolean flag=true;//设置标志位判断正负
        if(chars[0]=='-'){
            flag=false;
        }
        long number=0;//保存最后结果
        for(int i=0;i<chars.length;i++){
            if(i==0&&(chars[i]=='+'||chars[i]=='-')){
                continue;
            }
            if(chars[i]>'9'||chars[i]<'0'){//非法输入
                return 0;
            }
            number=(chars[i]-'0')+number*10;
            if(flag == true && number>Integer.MAX_VALUE)
                return 0;
            if(flag == false && (-number)<Integer.MIN_VALUE)
                return 0;
        }
        return (int)((flag==true)?number:(-number));//2147483647
    }

}
