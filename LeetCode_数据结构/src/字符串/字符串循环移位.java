package 字符串;
/*s = "abcd123" k = 3  Return "123abcd"
将字符串向右循环移动 k 位。
将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。*/
public class 字符串循环移位 {
    public static void main(String[] args) {
        String str="abcd123";
        System.out.println(xunhuanyidong(str,3));
    }
    public static String xunhuanyidong(String str,int k){
        StringBuilder stringBuilder=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb1.append(str.charAt(i));
            if(sb1.length()==str.length()-k){
                break;
            }
        }
        for(int i=str.length()-k;i<str.length();i++){
            sb2.append(str.charAt(i));
            if(sb2.length()==k){
                break;
            }
        }
        stringBuilder.append(sb1.reverse()).append(sb2.reverse());
        return stringBuilder.reverse().toString();
    }
}
