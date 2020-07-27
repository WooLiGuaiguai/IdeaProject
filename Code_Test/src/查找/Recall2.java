package 查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recall2 {
    public static void main(String[] args) {
        System.out.println (combinationSum2(new int[]{10,1,2,7,6,1,5},8));
        System.out.println(combinationSum3(3,9));
        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));
        System.out.println(partition("aabb"));
        char[][] suDo={{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},};
        Recall2 recall2=new Recall2();
        recall2.solveSudoku(suDo);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(suDo[i][j]+"   ");
            }
            System.out.println();
        }
    }
    //14.编写一个程序，通过已填充的空格来解决数独问题。
    private boolean [][]rowUsed=new boolean[9][10];
    private boolean [][]colUsed=new boolean[9][10];
    private boolean [][]cubeUsed=new boolean[9][10];
    private char [][] board_new;//用来存储复制成功的之前的数据以及将空白数据填入
    //获取子正方形的序号
    public static int calCube(int row,int col){
        row=row/3;
        col=col/3;
        return row*3+col;
    }
    public void solveSudoku(char[][] board) {
        board_new=board;
        for(int i=0;i<9;i++){//给已经存在的数标记到约束数组
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num=board[i][j]-'0';
                rowUsed[i][num]=true;
                colUsed[j][num]=true;
                cubeUsed[calCube(i,j)][num]=true;
            }
        }
        Back_nums9(0,0);
    }
    public boolean Back_nums9(int row,int col){
        //找到合规的空位置
        while (row<9&&board_new[row][col]!='.'){
            row=col==8?row+1:row;//目前遍历到的是不是一行中的最后一个
            col=col==8?0:col+1;
        }
        if(row==9){//如果遍历到row=9 意味着全部的表都已经遍历完且没有返回false
            return true;
        }
        //开始填数  1-9分别填进去尝试
        for(int num=1;num<=9;num++){
            if(rowUsed[row][num]||colUsed[col][num]||cubeUsed[calCube(row,col)][num]){
                continue;//数如果存在了 换下一个
            }
            rowUsed[row][num]=true;//标记到约束数组
            colUsed[col][num]=true;
            cubeUsed[calCube(row,col)][num]=true;
            board_new[row][col]=(char)(num+'0');//放进表格
            if(Back_nums9(row,col)){//往后走都成立就返回true
                return true;
            }
            //如果存在不成立的情况
            board_new[row][col]='.';
            rowUsed[row][num]=false;//约束数组进行清除
            colUsed[col][num]=false;
            cubeUsed[calCube(row,col)][num]=false;
        }
        return false;
    }
    //13.给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串(对称字符串) 返回 s 所有可能的分割方案。
    public static List<List<String>> partition(String s) {
        List<List<String>> Lists=new ArrayList<>();
        List<String> lists=new ArrayList<>();
        doParttion( s,Lists,lists);
        return Lists;
    }
    public static void doParttion(String s,List<List<String>> Lists,List<String> lists){
        if(s.length()==0){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,0,i)){//判断当前字符串是不是回文串
                lists.add(s.substring(0,i+1));
                doParttion(s.substring(i+1),Lists,lists);
                lists.remove(lists.size()-1);
            }
        }
    }
    //判断是否是回文串
    public static boolean isPalindrome(String string,int start,int end){
        while (start<end){//数组长度是奇数 二者相同时停止，如果是偶数 就是end<start时停止
            if(string.charAt(start)!=string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //12.给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 90
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        boolean [] visited=new boolean[nums.length];
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            Back_nums8(Lists,lists,nums,visited,i,0);
        }
        return Lists;
    }
    public static void Back_nums8(List<List<Integer>> Lists,List<Integer> lists,int []nums,boolean[]visited,int size,int start){
        if(size==lists.size()){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]){
                continue;
            }
            visited[i]=true;
            lists.add(nums[i]);
            Back_nums8(Lists,lists,nums,visited,size,i+1);
            lists.remove(lists.size()-1);
            visited[i]=false;
        }
    }
    //11.给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 78
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            Back_nums7(Lists,lists,nums,i,0);
        }
        return Lists;
    }
    public static  void Back_nums7(List<List<Integer>> Lists,List<Integer> lists,int []nums,int size,int start){
        if(size==lists.size()){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=start;i<nums.length;i++){
            lists.add(nums[i]);
            Back_nums7(Lists,lists,nums,size,i+1);
            lists.remove(lists.size()-1);
        }
    }
    //10. 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。  216
    //分析1-9这几个数的组合且没有重复数字  所以不用visited
    //每种组合中不存在重复的数字   所以使用start
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        Back_nums6(Lists,lists,1,k,n);
        return Lists;
    }
    public static  void Back_nums6(List<List<Integer>> Lists,List<Integer> lists,int start,int k,int n){
        if(k==0&&n==0){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        if(k==0||n==0){//在不满足上面if的条件下，如果k==0 n!=0 意味着不符合n k的要求；反之同理
            return;
        }
        for(int i=start;i<=9;i++){
            lists.add(i);
            Back_nums6(Lists,lists,i+1,k-1,n-i);
            lists.remove(lists.size()-1);
        }
    }
    //9. 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的每个数字在每个组合中只能使用一次。   40
    //排序实现的是排列时出现重复的排列 通过visited 数组实现：1，1，2，5中  第一个1组成的：1,2,5  第二个1也组成：1,2,5  避免出现这种情况！
    //target实现的是数字和问题  start实现的是组合的不重复选取（即对同一个数字的不重复选取）
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        boolean []visited=new boolean[candidates.length];
        Arrays.sort(candidates);
        Back_nums5(Lists,lists,visited,0,candidates,target);
        return Lists;
    }
    public static  void Back_nums5(List<List<Integer>> Lists,List<Integer> lists,boolean []visited,int start,int[] candidates, int target){
        if(target==0){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i!=0&&candidates[i]==candidates[i-1]&&!visited[i-1]){
                continue;
            }
            if(candidates[i]<=target){
                visited[i]=true;
                lists.add(candidates[i]);
                Back_nums5(Lists,lists,visited,i+1,candidates,target-candidates[i]);
                lists.remove(lists.size()-1);
                visited[i]=false;
            }
        }
    }
}
