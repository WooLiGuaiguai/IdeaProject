package 数组;

import java.util.ArrayList;

//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序，最短序列不得小于1
public class 和为S的所有连续正数序列 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        int start=1,end=2;//标记起始和终止点
        int cursum=3;
        while(end<sum){
            if(sum>cursum){
                end++;
                cursum=cursum+end;
            }else if(sum<cursum){
                cursum=cursum-start;
                start++;
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=start;i<=end;i++){
                    list.add(i);
                }
                lists.add(list);
                cursum=cursum-start;
                start++;
                end++;
                cursum=cursum+end;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }
}
