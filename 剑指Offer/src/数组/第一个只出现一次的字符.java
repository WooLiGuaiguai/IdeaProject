package 数组;

import java.util.BitSet;

public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str){
        char []chars=str.toCharArray();
        BitSet set1=new BitSet(256);//将指定位设置成true
        BitSet set2=new BitSet(256);
        for(int i=0;i<str.length();i++){
            if(!set1.get(chars[i]) && !set2.get(chars[i])){
                set1.set(chars[i]);
            }else if(set1.get(chars[i]) && !set2.get(chars[i])){
                set2.set(chars[i]);
            }
        }
        for(int i=0;i<str.length();i++){
            if (set1.get(chars[i]) && !set2.get(chars[i])){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str="abcdefgabcef";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
