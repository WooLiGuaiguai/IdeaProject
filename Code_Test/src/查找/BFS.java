package 查找;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//广度优先搜索
//可以求解最短路径最优解问题：第一次遍历到目的结点，所经过的路径为最短路径
//使用BFS只能求解无权图的最短路径  权重代价均为1
//在程序实现 BFS 时需要考虑以下问题：
//   队列：用来存储每一轮遍历得到的节点；
//   标记：对于遍历过的节点，应该将它标记，防止重复遍历。
public class BFS {
    public static void main(String[] args) {
        int[][] a={{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(a));
        System.out.println(numSquares(4));
        List<String> wordList=new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength("hit","cog",wordList));
    }
    //给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
    //每次转换只能改变一个字母，转换过程中的中间单词必须是字典中的单词。--leetcode127
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);//构建的这个图中必须包含所有的点  默认beginword不在这个字典里
        int num=wordList.size();
        int start=num-1;//标记beginword的index  它刚添加进来
        int end= 0;//确定字典中endword的index
        while (end<num&&!wordList.get(end).equals(endWord)){
            end++;//查找endword的位置  get是返回end+1位置上的值
        }
        if(end==num){//没有找到endword
            return 0;
        }
        //知道起始点和重点 构建图
        List<Integer> []graphic=graphic_build(wordList);
        return getShortestPath(graphic, start, end);
    }
    public static List<Integer>[] graphic_build(List<String> wordList){
        //返回的这个图 是list集合的集合  里面每个元素是一个点相邻接点的坐标组成的集合
        int N=wordList.size();
        List<Integer> []graphic =new List[N];
        for(int i=0;i<N;i++){
            graphic[i]=new ArrayList<Integer>();
            for(int j=0;j<N;j++){
                if(isConnect(wordList.get(i),wordList.get(j))){
                    graphic[i].add(j);//将相连接的结点坐标传进来
                }
            }
        }
        return graphic;
    }
    public static boolean isConnect(String a,String b){
        int different=0;
        for(int i=0;i<a.length()&&different<=1;i++){
            if(a.charAt(i)!=b.charAt(i)){
                different++;
            }
        }
        //只有一个元素不同时才是属于连接状态
        return different==1;
    }
    public static int getShortestPath(List<Integer> []graphic,int start,int end){
        Queue<Integer>queue=new LinkedList<>();
        boolean []flag=new boolean[graphic.length+1];
        queue.add(start);
        flag[start]=true;
        int length=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            length++;
            while(size-->0){
                int cur=queue.poll();
                for (int next : graphic[cur]) {
                    if(next==end){
                        return length;
                    }
                    if(flag[next]){
                        continue;
                    }
                    flag[next]=true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
    //给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    //分析得：首先获得小于n的所有完全平方数  然后从结点n开始逐步减去这些完全平方数，每次减法过后的结果加入到队列
    //队列中的每个结果都重复上面的步骤  直到某一时刻减法过后的结果为0说明结点n到结点0的最短路径找到了
    public static int numSquares(int n) {
        List<Integer> Squares=Squares(n);//获取集合
        Queue<Integer> queue=new LinkedList<>();
        boolean [] flag=new boolean[n+1];
        queue.add(n);//第一个元素
        int level=0;//统计个数
        while (!queue.isEmpty()){
            int size=queue.size();
            level++;//此时queue中存在的数字 和前一个数字都是直连关系 路径都是相等的 1
            while (size-->0){
                int cur=queue.poll();//出队列第一个元素 开始遍历
                for (int square : Squares) {
                    int next=cur-square;
                    if(next<0){//如果小于0 说明后面的square也会导致next小于0 直接退出
                        break;
                    }
                    if(next==0){
                        return level;
                    }
                    if(flag[next]){
                        continue;
                    }
                    flag[next]=true;
                    queue.add(next);
                }
            }
        }
        return n;//没找到 会有n个1连接而成
    }
    public static List<Integer> Squares(int n){//获取完全平方数集合
        int input=1;
        int add=3;
        List<Integer> lists=new ArrayList<>();
        while(input<=n){
            lists.add(input);
            input=input+add;//获取下一个完全平方数
            add=add+2;
        }
        return lists;
    }
    public static int shortestPathBinaryMatrix(int[][] grids){
        if(grids==null||grids.length==0||grids[0].length==0){
            return -1;
        }
        //每个元素周围有8个位置可以进行移动   每个数组对应x y坐标变化情况
        int [][] direction={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        //确定这个图的长度和宽度
        int m=grids.length,n=grids[0].length;
        //每个元素是有x y左边，用一个pair类型的队列来存储  并且让第一个元素入队列
        Queue<Pair<Integer,Integer>> pairs=new LinkedList<>();
        pairs.add(new Pair<>(0,0));
        int len=0;//最终要返回的长度
        while(!pairs.isEmpty()){
            int size=pairs.size();
            len++;//认为遍历了一个点  长度加一
            while(size>0){
                Pair<Integer, Integer> point = pairs.poll();//将 点 出队列
                size--;
                int x=point.getKey(),y=point.getValue();//获取点的横纵坐标
                if(grids[x][y]==1){
                    continue;
                }
                if(x==m-1&&y==n-1){
                    return len;
                }
                grids[x][y]=1;//防止重复遍历
                for (int[] ints : direction) {
                    //保存移动之后的临时结点 不可以直接x=x+ints[0] 因为要向8个方向移动 移动的起始点不能变
                    int x_tp=x+ints[0];
                    int y_tp=y+ints[1];
                    if(x_tp<0||x_tp>=m||y_tp<0||y_tp>=n){//把周围所有可能的点都加进来
                        continue;
                    }
                    pairs.add(new Pair<>(x_tp,y_tp));
                }
            }
        }
        return -1;
    }
}
