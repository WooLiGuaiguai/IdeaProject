package cn.ccTengx.day0205;

public class Convert_Split {
    /*public char[] toCharArray ();将此字符串转换为新的字符数组。
    public byte[] getBytes () ;使用平台的默认字符集将该 String编码转换为新的字节数组。
    public String replace (CharSequence target, CharSequence replacement) ;将与target匹配的字符串使
            用replacement字符串替换
    public String[] split(String regex) ：将此字符串按照给定的regex（规则）拆分为字符串数组
    如果使用“.”进行划分，应该用“\\.”*/
    public static void main(String[] args) {
        String str="hellowolrd i am owo";
        char [] chars=str.toCharArray();
        System.out.println(chars);
        byte [] bytes=str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]+"  ");
        }
        String str2=str.replace("o","xx");
        System.out.println(str2);
        String[] strings=str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
