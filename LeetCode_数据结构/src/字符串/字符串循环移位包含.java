package 字符串;

public class 字符串循环移位包含 {
    public static void main(String[] args) {
        System.out.println(find_str("aabcd","cdaa"));
    }
    public static boolean find_str(String str1,String str2){
        StringBuilder stringBuilder=new StringBuilder();
        char []chars=str1.toCharArray();
        for (int i=0;i<chars.length*2;i++) {
            stringBuilder.append(chars[i%chars.length]);
        }
        char [] cs=stringBuilder.toString().toCharArray();
        int j;
        for(int i=0;i<stringBuilder.length();i++){
            char[]chars1=str2.toCharArray();
            for(j=0;j<chars1.length;j++){
                if(cs[i+j]!=chars1[j]){
                    break;
                }
            }
            if(j==chars1.length){
                return true;
            }
        }
        return false;
    }
}
