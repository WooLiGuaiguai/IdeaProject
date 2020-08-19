package 递归问题;

public class 矩阵路径问题 {
    private int [][]direction={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean []isVisited=new boolean[matrix.length];//判断是否被访问
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isRoad(matrix,i,rows,j,cols,str,isVisited,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isRoad(char []matrix,int i,int rows,int j,int cols,char[]str,boolean[]isVisited,int curlen){
        if(curlen==str.length){
            return true;
        }
        //i j分别表示当前起始坐标 将二维数组转化成需要的数组
        int index=i*cols+j;
        if(i<0||j<0||i>=rows||j>=cols||index>=matrix.length||isVisited[index]||matrix[index]!=str[curlen]){
            return false;
        }
        curlen++;//当前长度
        isVisited[index]=true;
        for (int[] ints : direction) {
            int nextI=i+ints[0];
            int nextJ=j+ints[1];
            if(isRoad(matrix,nextI,rows,nextJ,cols,str,isVisited,curlen)){
                return true;
            }
        }
        curlen--;
        isVisited[index]=false;
        return false;
    }

    public static void main(String[] args) {
        String string="abcesfcsadee";
        String str="bcced";
        char[]strs=str.toCharArray();
        char[]chars=string.toCharArray();
        矩阵路径问题 a=new 矩阵路径问题();
        System.out.println(a.hasPath(chars,4,4,strs));
        System.out.println(a.hasPath(chars,4,4,"abcb".toCharArray()));
    }
}
