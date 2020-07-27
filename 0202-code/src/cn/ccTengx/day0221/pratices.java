package cn.ccTengx.day0221;

public class pratices {
    public static void main(String[] args) {
        //System.out.println(cutRope(8));
       // System.out.println(BitSum(39));
        //System.out.println(movingCount(18,40,40));
        char []char1={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char []char2={'b','c','c','e','d'};
        char []char3={'a','b','c','b'};
        System.out.println(hasPath(char1,3,4,char2));
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix==null||matrix.length<str.length||matrix.length<=0||str==null
                ||str.length<=0||matrix.length<rows*cols||rows<=0||cols<=0){
            return false;
        }
        boolean []visit=new boolean[rows*cols];
        int length=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isPath(matrix,rows, cols, str,i,j,length,visit)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isPath(char[] matrix, int rows, int cols, char[] str,int r,int c,int length,boolean[] visit){
        int index=r*cols+c;//将矩阵坐标值转化成一维数组坐标  r c表示的是坐标值
        //递归终止条件
        if(r<0||c<0||r>=rows||c>=cols||visit[index]==true||matrix[index]!=str[length]){
            return false;
        }
        //已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(length==str.length-1){
            return true;
        }
        //没有到达末尾 但是此位匹配成功  标记已经访问过
        visit[index]=true;
        if(       isPath(matrix,rows,cols,str,r-1,c,length+1,visit)
                ||isPath(matrix,rows,cols,str,r,c-1,length+1,visit)
                ||isPath(matrix,rows,cols,str,r+1,c,length+1,visit)
                ||isPath(matrix,rows,cols,str,r,c+1,length+1,visit)){
            return true;
        }
        //前后左右没有匹配成功 还原到上一个结点 重新试
        visit[index]=false;
        return false;
    }

    public static int movingCount(int threshold, int rows, int cols) {
        boolean [][] visit=new boolean[rows][cols];
        return countsteps(threshold, rows, cols,0,0,visit);
    }
    public static int countsteps(int threshold, int rows, int cols,int r,int c,boolean[][] visit){
        if(r<0||c<0||r>=rows||c>=cols||visit[r][c]==true||threshold<(BitSum(r)+BitSum(c))){
            return 0;
        }
        visit[r][c]=true;//r c代表的是坐标 并不是第r行 第c列
        return 1+countsteps(threshold,rows,cols,r-1,c,visit)
                +countsteps(threshold,rows,cols,r,c-1,visit)
                +countsteps(threshold,rows,cols,r+1,c,visit)
                +countsteps(threshold,rows,cols,r,c+1,visit);
    }
    public static int BitSum(int number){
        int count=0;
        while(number>0){
            /*count=number/10;
              number=number%10;
              这种情况 number最后等于个位上数值 count一直加0 死循环*/
            count=count+number%10;//这样先加个位数值
            number=number/10; //然后一做除法  number直接等于十位上数值
        }
        return count;
    }
    public static int cutRope(int target) {
        if(target<2){
            return 0;
        }
        if(target==2){//m>1 所以n=2 s=1*1
            return 1;
        }
        if(target==3){//n=3 s=1*2
            return 2;
        }
        int x=target/3;
        int y=target%3;
        if(y==0){//target是3的整倍数
            return (int)Math.pow(3,x);
        }else if(y==1){
            //余数是1 3*1<2*2 所以从前面3的整倍数中抽出一个3组成2*2
            return (int)(2*2*Math.pow(3,x-1));
        }else{
            return (int)(2*Math.pow(3,x));
        }
    }



}
