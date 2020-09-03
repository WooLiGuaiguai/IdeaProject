package 图的练习;

public class Prim_map {
    public static void main(String[] args) {
        float m = Float.MAX_VALUE;
        float[][] weight = {
                {0, 6, 1, 5, m, m},
                {6, 0, 5, m, 3, m},
                {1, 5, 0, 5, 6, 4},
                {5, m, 5, 0, m, 2},
                {m, 3, 6, m, 0, 6},
                {m, m, 4, 2, 6, 0}};//上图的矩阵
        System.out.println(prim(weight.length, weight));//求最短路径
        //prim(weight.length, weight);

    }
    public static float prim(int num,float[][]weight){
        float length=0;//路径总长度   求最短路径
        //1.辅助数组
        float [] lowcost=new float[num];//记录每个点到集合的最小值
        int [] adjvex=new int[num];//记录与集合相连接的最小权边的点
        boolean []visited=new boolean[num];//判断点是否加入到集合中
        //2.初始化辅助数组
        visited[0]=true;//添加进来第一个点
        adjvex[0]=0;
        for(int i=1;i<num;i++){
            visited[i]=false;
            adjvex[i]=0;
            lowcost[i]=weight[0][i];
        }
        //3.完成prim遍历
        for(int i=1;i<num;i++){
            float min=Float.MAX_VALUE;
            int j=0;//保存与集合相连的最小权边的点
            //3.1 根据最小权值加入新点
            for(int k=1;k<num;k++){
                if(!visited[k]&&lowcost[k]<min){
                    min=lowcost[k];
                    j=k;
                }
            }
            System.out.println("加入点："+j+" 相连接的边：（"+adjvex[j]+","+j+")  权值是："+min);
            length=length+min;//求最短路径
            visited[j]=true;
            //3.2 加入新点之后更新到各个结点的边的最小权值
            for(int k=1;k<num;k++){
                if(!visited[k]&&weight[j][k]<lowcost[k]){
                    lowcost[k]=weight[j][k];
                    adjvex[k]=j;
                }
            }
        }
        return length;//求最短路径
    }
}
