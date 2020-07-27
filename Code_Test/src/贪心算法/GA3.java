package 贪心算法;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class GA3 {
    public static void main(String[] args) {
        int [][]peopl={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int [][]people=reconstructQueue(peopl);
        for (int[] person : people) {
            for (int i : person) {
                System.out.print(i+"  ");
            }
            System.out.println(",");
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0||people[0].length==0){
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先判断身高h 相等的话k升序 不等的话 h降序
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        //然后将他们插入到一个输出队列中
        List<int[]> queue = new ArrayList<>();
        //然后不断的插入 实现的是更新型插入
        for(int [] p:people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[people.length][2]);
    }
}
