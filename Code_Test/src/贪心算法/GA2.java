package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class GA2 {
    public static void main(String[] args) {
        int [][]inter={{1,3},{2,4},{4,7},{8,9},{10,12}};
        System.out.println(eraseOverlapIntervals(inter));
        int [][]point={{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(point));

    }
    public static int findMinArrowShots(int[][] points){
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int end=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=end){//这时候边界重叠也属于有重叠部分了 因为一根飞镖可以从边界插过
                continue;
            }
            end=points[i][1];
            count++;
        }
        return count;
    }
    public static int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length==0){
            return 0;
        }
        //把这个数组看成是数组的集合，每个元素是一个数组，比较数组的第二位也就是区间的尾部
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int end=intervals[0][1];//将第一个区间的尾部设成初始值
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<end){
                continue;//必须确保和上一个区间不能重合
            }
            end=intervals[i][1];
            count++;
        }
        return intervals.length-count;
    }
}
