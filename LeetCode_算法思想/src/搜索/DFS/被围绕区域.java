package 搜索.DFS;
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

//X X X X
//X O O X
//X X O X
//X O X X
//运行你的函数后，矩阵变为：
//X X X X
//X X X X
//X X X X
//X O X X
public class 被围绕区域 {
    public static void main(String[] args) {
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int m=0,n=0;
    private static int [][]directions={{0,-1},{0,1},{-1,0},{1,0}};
    public static void solve(char[][] board){
        //首先考虑使用DFS 但是需要注意他也会改变边界（如果边界也符合条件）
        if(board==null||board.length==0||board[0].length==0){
            return;
        }
        m=board.length;
        n=board[0].length;
        //先处理边界
        for(int i=0;i<m;i++){
            change(board,i,0);
            change(board,i,n-1);
        }
        for(int j=0;j<n;j++){
            change(board,0,j);
            change(board,m-1,j);
        }
        //再将所有的'O'变成'X'  'T'变成'O'
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }

    }
    public static void change(char [][]board,int i,int j){//只是修改边界上的值
        if(i<0||i>=m||j<0||j>=n||board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        for(int []direcction:directions){
            change(board,i+direcction[0],j+direcction[1]);
        }
    }
}
