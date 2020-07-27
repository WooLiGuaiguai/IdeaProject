package 搜索.回溯;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false

public class 单词搜索 {
    public static void main(String[] args) {
        char [][]board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCCED"));
        System.out.println(exist(board,"SEE"));
        System.out.println(exist(board,"ABCB"));
    }
    private static int m=0;
    private static int n=0;
    private static int [][]directions={{0,-1},{0,1},{-1,0},{1,0}};
    public static boolean exist(char[][] board, String word){
        if(word==null||word.length()==0){
            return true;
        }
        if(board==null||board.length==0){
            return false;
        }
        m=board.length;
        n=board[0].length;//矩阵的长和宽
        boolean [][]flag=new boolean[m][n];//判断是否被访问
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(back_toFind(flag,board,word,i,j,0)){//如果找到 返回true
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean back_toFind(boolean[][] flag,char[][]board,String word,int i,int j,int curlen){
        if(curlen==word.length()){
            return true;
        }
        if(i<0||i>=m||j<0||j>=n||flag[i][j]||board[i][j]!=word.charAt(curlen)){
            return false;
        }
        flag[i][j]=true;
        curlen++;
        for (int[] direction : directions) {
            int nextI=i+direction[0];
            int nextJ=j+direction[1];
            if(back_toFind(flag,board,word,nextI,nextJ,curlen)){
                return true;
            }
        }
        //否则就是没有找到
        flag[i][j]=false;
        return false;
    }
}
