package 递归问题;
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格
//但是不能进入行坐标和列坐标的数位之和大于k的格子。
//例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
public class 机器人的活动范围 {
    private int [][]directions={{1,0},{-1,0},{0,1},{0,-1}};
    private int count=0;//用来统计格子的个数
    public int movingCount(int threshold, int rows, int cols){
        boolean [][]isVisited=new boolean[rows][cols];
        addCount(threshold,0,0,rows,cols,isVisited);//能够到达多少个格子意味着这是可达性问题 所以不要循环
        return count;
    }
    public void addCount(int k,int i,int j,int rows,int cols,boolean [][]isVisited){
        if(i<0||i>=rows||j<0||j>=cols||isVisited[i][j]||(kCnt(i)+kCnt(j))>k){
            return;
        }
        isVisited[i][j]=true;
        count++;
        for (int[] direction : directions) {
            int nextI=i+direction[0];
            int nextJ=j+direction[1];
            addCount(k,nextI,nextJ,rows,cols,isVisited);
        }
    }
    public int kCnt(int num){//拆分计算
        int sum=0;
        while(num>0){//239
            sum+=num%10;//9
            num=num/10;//23
        }
        return sum;
    }

    public static void main(String[] args) {
        机器人的活动范围 a=new 机器人的活动范围();
        System.out.println(a.movingCount(10,1,100));
    }
}
