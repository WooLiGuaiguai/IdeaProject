package 图的练习;

public class Floyd_map {
    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int [][]matirx=new int[][]{
                {0, 1, 5, m, m, m, m, m, m},
                {1, 0, 3, 7, 5, m, m, m, m},
                {5, 3, 0, m, 1, 7, m, m, m},
                {m, 7, m, 0, 2, m, 3, m, m},
                {m, 5, 1, 2, 0, 3, 6, 9, m},
                {m, m, 7, m, 3, 0, m, 5, m},
                {m, m, m, 3, 6, m, 0, 2, 7},
                {m, m, m, m, 9, 5, 2, 0, 4},
                {m, m, m, m, m, m, 7, 4, 0}};
        Floyd(matirx);
    }

    public static void Floyd(int [][]matirx){
        int i,j,k;//用来保存判断是否需要中间点出现时的结点下标  i是起点 j是终点 k是中转点
        //1. 初始化D 和P矩阵
        int [][]D=new int[matirx.length][matirx.length];
        int [][]P=new int[matirx.length][matirx.length];
        for(i=0;i<D.length;i++){
            for(j=0;j<D.length;j++){
                D[i][j]=matirx[i][j];
                P[i][j]=j;
            }
        }
        //2. 开始更新
        for(k=0;k<matirx.length;k++){
            for(i=0;i<matirx.length;i++){
                for(j=0;j<matirx.length;j++){
                    int MaxPath=(D[i][k]==Integer.MAX_VALUE||D[k][j]==Integer.MAX_VALUE)?Integer.MAX_VALUE:D[i][k]+D[k][j];
                    if(D[i][j]>MaxPath){
                        D[i][j]=MaxPath;
                        P[i][j]=P[i][k];
                    }
                }
            }
        }
        for (int m = 0; m < matirx.length; m++) {
            for (int n = m + 1; n < matirx.length; n++) {
                k = P[m][n];
                System.out.print("(" + m + "," + n + ")：");//获得第一个路径顶点下标
                System.out.print(m);//打印源点
                while (k != n) {//如果路径顶点下标不是终点
                    System.out.print("->" + k);//打印路径顶点
                    k = P[k][n];//获取下一个路径顶点下标
                }
                System.out.println("->" + n);//打印终点
            }
            System.out.println();
        }
    }
}
