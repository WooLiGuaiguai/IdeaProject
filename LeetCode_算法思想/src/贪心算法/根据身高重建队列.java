package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示
// 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
public class 根据身高重建队列 {
    public static void main(String[] args) {
        int [][]people={{7,0},{4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int [][]newpeople=reconstructQueue(people);
        for(int i=0;i<people.length;i++){
            for (int j=0;j<2;j++){
                System.out.print(newpeople[i][j]+" ");
            }
            System.out.println();
        }
    }
    //首先进行局部分析，当身高相同的时候，应该按照k升序排列
    //其次，身高不同的时候，高个子在前面
    public static int[][] reconstructQueue(int[][] people){
        if(people==null||people.length==0){
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];//70 71 61 50 52 44
            }
        });
        List<int[]> list=new ArrayList<>();
        for(int []num:people){
            list.add(num[1],num);
        }
        return list.toArray(new int[people.length][2]);
    }
}
