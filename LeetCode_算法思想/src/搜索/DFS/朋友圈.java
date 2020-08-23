package 搜索.DFS;
//班上有 N 名学生。的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
// 所谓的朋友圈，是指所有朋友的集合。
//给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
//你必须输出所有学生中的已知的朋友圈总数。
public class 朋友圈 {
    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(M));
    }
    public static int findCircleNum(int[][] M){
        if(M==null||M.length==0){
            return 0;
        }
        int m=M.length;//学生个数
        boolean []flag= new boolean[m];//标记是否被访问
        int count=0;//朋友圈个数
        for(int i=0;i<m;i++){
            if(!flag[i]){
                DFS_friend(M,i,flag);//确定可达结点 并把他们置为已访问
                count++;
            }
        }
        return count;
    }
    public static void DFS_friend(int [][]M,int i,boolean []flag){
        flag[i]=true;//标记被访问
        for(int j=0;j<M.length;j++){
            if(!flag[j] && M[i][j]==1 ){
                DFS_friend(M,j,flag);
            }
        }
    }

}
