package 字符串;
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
public class 最长公共前缀 {
    //纵向比较
    public static String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0){
            return "";
        }
        int count=strs.length;
        int length1=strs[0].length();
        for(int i=0;i<length1;i++){
            char c=strs[0].charAt(i);//获取第一个字符
            //然后和String数组中的其他字符串进行比较
            for(int j=1;j<count;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strings={"flower","flow","flight"};
        String []strings1={"C","C"};
        System.out.println(longestCommonPrefix(strings));
        System.out.println(longestCommonPrefix(strings1));
    }
}
