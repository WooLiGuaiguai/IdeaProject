package 数组;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
//输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G

import java.util.ArrayList;
import java.util.List;

public class Z字形变换 {
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<StringBuilder> rows=new ArrayList<>();//每行设置一个sb对象 最后把每行连接起来输出
        for(int i=0;i<(Math.min(s.length(),numRows));i++){
            //防止s的长度是3  而numRows的值是4
            rows.add(new StringBuilder());
        }
        boolean godown=false;
        int curRow=0;//当前行号
        for(char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow==0||curRow==numRows-1){
                godown=!godown;//掉头
            }
            //看是否还是继续向下走 如果是 curRow+1 否则向上走 -1
            curRow=curRow+(godown==true ? 1:-1);
        }
        StringBuilder result=new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(convert(s,numRows));
    }
}
