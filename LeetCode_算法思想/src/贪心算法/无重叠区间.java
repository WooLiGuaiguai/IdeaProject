package 贪心算法;
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//可以认为区间的终点总是大于它的起点。
//区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//示例 1:
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//输出: 1

import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间 {
    public static void main(String[] args) {
        int [][]intervial={{1,2},{2,3},{3,4},{2,4}};
        System.out.println(eraseOverlapIntervals(intervial));
    }
    public static int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int end=intervals[0][1];//标记第一个的末位 之所以可以标记，是因为前面已经根据区间的末位进行的排序 升序排序
        for(int []num:intervals){
            if(num[0]<end){
                continue;
            }
            count++;
            end=num[1];
        }
        return intervals.length-count;
    }
}
