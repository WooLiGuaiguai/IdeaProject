import java.util.ArrayList;
import java.util.List;

public class 编程测验_滑雪 {
    public static void main(String[] args) {
        int [][]iceArea={  {1,2,3,4,5},
                           {16,17,18,19,6},
                           {15,24,25,20,7},
                            {14,23,22,21,8},
                            {13,12,11,10,9}};
        System.out.println(play(5,5,iceArea));
    }
    private static int [][]directions={{0,-1},{0,1},{-1,0},{1,0}};
    public static int play(int m,int n,int [][]iceArea){
        /*int [][]iceArea=new int [m][n];
        for (int i=0;i<m;i++){//初始化
            for (int j=0;j<n;j++){
                iceArea[i][j]=i*5+(j+1);//1 2 3 4 5/6 7 8 9 10
            }
        }*/
        boolean [][]flag=new boolean[m][n];
        int len=0;
        List<Integer>list=new ArrayList<>();
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                DFS_LEN(iceArea,i,j,m,n,flag,list,lists);
            }
        }
        for (List<Integer> list1 : lists) {
            len=Math.max(len,list1.size());
        }
        return len;
    }
    public static void DFS_LEN(int [][]iceArea, int start, int end, int m, int n, boolean[][]flag, List<Integer>list,List<List<Integer>> lists){
        if(start<0||start>=m||end<0||end>=n||flag[start][end]){//被访问
            return ;
        }
        flag[start][end]=true;
        list.add(iceArea[start][end]);
        for (int[] direction : directions) {
            int nextI=start+direction[0];
            int nextJ=end+direction[1];
            if(nextI<0 ||nextI>=m || nextJ<0 || nextJ>=n || iceArea[nextI][nextJ]>=iceArea[start][end]||flag[nextI][nextJ]){
                continue;
            }
            DFS_LEN(iceArea,nextI,nextJ,m,n,flag,list,lists);
        }
        lists.add(new ArrayList<>(list));
        flag[start][end]=false;
        list.remove(list.size()-1);
    }
}
