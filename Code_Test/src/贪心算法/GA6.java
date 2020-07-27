package 贪心算法;

public class GA6 {
    public static void main(String[] args) {
        String s="axc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));

    }
    public static boolean isSubsequence(String s, String t) {
        if((s.length()==0)||t.length()==0){
            return false;
        }
        int i=0,j=0;
        char []chars=s.toCharArray();
        char []chart=t.toCharArray();
        while (i<s.length()&&j<t.length()){
            if(chars[i]==chart[j]){
                i++;j++;
            }else{
                j++;
            }
        }
        if(i==s.length()){
            return true;
        }
        return false;
    }
}
