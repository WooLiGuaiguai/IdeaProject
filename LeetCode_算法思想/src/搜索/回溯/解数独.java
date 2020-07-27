package 搜索.回溯;
//编写一个程序，通过已填充的空格来解决数独问题。
//
//一个数独的解法需遵循如下规则：
//
//数字 1-9 在每一行只能出现一次。
//数字 1-9 在每一列只能出现一次。
//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//空白格用 '.' 表示。

import java.net.Socket;

public class 解数独 {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        解数独 mm=new 解数独();
        mm.solveSudoku(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    //首先考虑条件 行 列以及3x3宫内部都不能有相同的数字 所以设置三个数组 分别记录行列和宫哪个数字是否出现
    private  boolean [][]rowUsed=new boolean[9][10];//之所以后面设为10 是因为存储的时候会存到rowUsed[i][9]
    private  boolean [][]colUsed=new boolean[9][10];//列宫数组  横坐标表示序号 纵坐标表示存储的数字
    private  boolean [][]cubeUsed=new boolean[9][10];//3x3宫数组 横坐标表示序号 纵坐标表示存储的数字
    //然后需要考虑怎么表示这个宫  按照从左到右从上到下进行标号
    public  int CalCube(int row,int col){
        row=row/3;
        col=col/3;
        return row*3+col;
    }
    //紧接着需要考虑通过遍历二维数组将新建的数组进行初始化
    public  void solveSudoku(char[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num=board[i][j]-'0';
                rowUsed[i][num]=true;
                colUsed[j][num]=true;
                cubeUsed[CalCube(i,j)][num]=true;
            }
        }
        SolveSudo(board,0,0);
    }
    public  boolean SolveSudo(char[][]board,int row,int col){
        //找到合规的空位置   之所以写成这样 是因为填入之后需要接着递归调用该方法查找后面的位置
        while (row<9&&board[row][col]!='.'){
            row=col==8?row+1:row;//目前遍历到的是不是一行中的最后一个
            col=col==8?0:col+1;
        }
        if(row==9){//如果遍历到row=9 意味着全部的表都已经遍历完且没有返回false
            return true;
        }
        //现在找到一个空白处 开始填数  从1-9进行遍历
        for(int i=1;i<=9;i++){
            if(rowUsed[row][i]||colUsed[col][i]||cubeUsed[CalCube(row,col)][i]){
                continue;
            }
            rowUsed[row][i]=true;//标记到约束数组
            colUsed[col][i]=true;
            cubeUsed[CalCube(row,col)][i]=true;
            board[row][col]=(char)(i+'0');//放进表格
            if(SolveSudo(board,row,col)){//往后走都成立就返回true
                return true;
            }
            rowUsed[row][i]=false;//取消标记
            colUsed[col][i]=false;
            cubeUsed[CalCube(row,col)][i]=false;
            board[row][col]='.';
        }
        return false;
    }

}
