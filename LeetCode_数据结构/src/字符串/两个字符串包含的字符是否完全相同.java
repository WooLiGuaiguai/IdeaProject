package 字符串;
//判断两个字符串包含的字母的种类和个数是否完全一样 只是顺序不一样
public class 两个字符串包含的字符是否完全相同 {
    public static void main(String[] args) {
        System.out.println(isAnagram("aassddff","asdfafd"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        //创建一个26个位置的数组来存放每个字母出现的次数
        int[] arr=new int[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c-'a']--;
        }
        for (int i : arr) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
