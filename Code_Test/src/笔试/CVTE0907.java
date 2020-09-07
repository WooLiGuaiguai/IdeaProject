package 笔试;

public class CVTE0907 {
    public static int findMinAirTicketPrice(int W,int [][]matirx,int A,int B){
        int i,j,k;
        int [][]D=new int[matirx.length][matirx.length];
        int [][]P=new int[matirx.length][matirx.length];
        for(i=0;i<D.length;i++){
            for(j=0;j<D.length;j++){
                D[i][j]=matirx[i][j];
                P[i][j]=j;
            }
        }
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
        int sum=0;
        k = P[A][B];
        sum+=matirx[A][k];
        while (k != B) {
            int l=k;
            k = P[k][B];
            sum+=matirx[l][k];
        }
        sum+=matirx[k][B];
        return sum;
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int [][]matrix={
                {0, 600, 1300},
                {m, 0, 500},
                {m, m, 0,}};
        System.out.println(findMinAirTicketPrice(3,matrix,0,2));
    }
}
