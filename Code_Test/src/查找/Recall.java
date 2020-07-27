package 查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recall {

    public static void main(String[] args) {
        char[][] board = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        String word1 = "SEE";
        String word2 = "ABCB";
        System.out.println(exist(board,word));
        System.out.println(exist(board,word1));
        System.out.println(exist(board,word2));
        System.out.println(permute(new int[]{1,2,3}));
        System.out.println(permuteUnique(new int[]{1,1,3}));
        System.out.println(Combinations_num(4,2));
        System.out.println(combinationSum(new int []{2,3,6,7},7));
    }
    //8.给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的数字可以无限制重复被选取。 39
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        Back_nums4(Lists,lists,0,candidates,target);
        return Lists;
    }
    public static  void Back_nums4( List<List<Integer>> Lists, List<Integer> lists,int start,int[] candidates, int target){
        if(target==0){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]<=target){
                lists.add(candidates[i]);
                Back_nums4(Lists,lists,i,candidates,target-candidates[i]);
                lists.remove(lists.size()-1);
            }
        }
    }
    //7.给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 77
    //要求是组合 不是排列  [1,2]和[2,1]等价   所以不用考虑是否被访问
    public static List<List<Integer>> Combinations_num(int n,int k){
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        if(n<k){
            return Lists;
        }
        Back_nums3(Lists,lists,1,n,k);
        return Lists;
    }
    public static void Back_nums3(List<List<Integer>> Lists,List<Integer> lists,int start,int n,int k){
        if(k==0){//意味着lists中的个数已经满足k个了 可以放入Lists
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=start;i<=n-k+1;i++){//组合意味着12 13 14 23 24 34这样 将i设置一个指针不断向后移动
            lists.add(i);
            Back_nums3(Lists,lists,i+1,n,k-1);//这样回溯从他后面一位开始 并且k--
            lists.remove(lists.size()-1);
        }
    }
    //6.给定一个可包含重复数字的序列，返回所有不重复的全排列。 47
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> lists=new ArrayList<>();
        boolean []visited=new boolean[nums.length];
        Arrays.sort(nums);
        Back_nums2(nums,Lists,lists,visited);
        return Lists;
    }
    public static void Back_nums2(int []nums,List<List<Integer>> Lists,List<Integer> lists,boolean []visited){
        if(lists.size()==nums.length){
            Lists.add(new ArrayList<>(lists));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //拿1 1 2来说   112 121之后 i=0上的1被标记为false  这时候i=1上的1由于同时满足括号三个条件 它便不能放到集合的第一个位置再次遍历
            if(i!=0&& nums[i]==nums[i-1] && !visited[i-1]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            lists.add(nums[i]);
            Back_nums2(nums,Lists,lists,visited);
            lists.remove(lists.size()-1);
            visited[i]=false;
        }
    }
    //5.给定一个 没有重复 数字的序列，返回其所有可能的全排列。 46
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> Lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();//每个list中添加数字 然后每个list相当于一个路径
        boolean []flag=new boolean[nums.length];
        Back_nums(nums,Lists,list,flag);
        return Lists;
    }
    public static void Back_nums(int[] nums,List<List<Integer>> Lists,List<Integer> list,boolean []flag){
        if(list.size()==nums.length){//一个路径中的长度等于输入数字的长度
            Lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<flag.length;i++){
            if(flag[i]){
                continue;
            }
            flag[i]=true;
            list.add(nums[i]);
            Back_nums(nums,Lists,list,flag);//进行回溯
            list.remove(list.size()-1);
            flag[i]=false;
        }
    }
    //4.给定一个二叉树，返回所有从根节点到叶子节点的路径。 257
    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }}
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> Paths=new ArrayList<>();
        if(root==null){
            return Paths;
        }
        List<Integer> values=new ArrayList<>();//用来存放每个节点的值  方便输出
        Back_findPath(root,values,Paths);
        return Paths;
    }
    public void Back_findPath(TreeNode root,List<Integer> values,List<String> Paths){
        if(root==null){return;}//还要进行判断 因为回溯会不断调用新的root节点
        values.add(root.val);//不为空 就添加进来
        if(root.left==null&&root.right==null){//如果是叶子结点 表示遍历到最后一个节点  将路径转换成字符串 添加到Paths中
            Paths.add(Build_Path(values));
        }else{
            Back_findPath(root.left,values,Paths);
            Back_findPath(root.right,values,Paths);
        }
        values.remove(values.size()-1);  //回溯的关键所在 remove传参是下标
    }
    public String Build_Path(List<Integer> values){
        int n=values.size();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<n;i++){
            stringBuilder.append(values.get(i));
            if(i<n-1){
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }
    //3.在矩阵中寻找字符串  79
    private  final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int m;
    private static int n;
    public static boolean exist(char[][] board, String word){
        if(word==null||word.length()==0){
            return true;
        }
        if(board==null||board.length==0){
            return false;
        }
        m=board.length;
        n=board[0].length;
        boolean [][]flags=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(back_toFind(board,word,flags,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean back_toFind(char[][] board, String word,boolean [][]flags,int i,int j,int cur){
        if(cur==word.length()){//找到字符串  假设word=4  cur=1时表示已经找到一个 所以cur=4时表示前面已经有四个 退出
            return true;
        }
        if(i<0||i>=m||j<0||j>=n||flags[i][j]||board[i][j]!=word.charAt(cur)){
            return false;
        }
        flags[i][j]=true;
        for (int[] ints : direction) {
            if(back_toFind(board,word,flags,i+ints[0],j+ints[1],cur+1))
                return true;
        }
        flags[i][j]=false;
        return false;
    }
    //2.划分IP地址 93
    //1.给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 17
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits){
        List<String> Lists=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();//用来表示每一个结果
        if(digits==null||digits.length()==0){//对输入字符串进行判断
            return Lists;
        }
        Combination_num(stringBuilder,Lists,digits);
        return Lists;
    }
    public static void Combination_num(StringBuilder stringBuilder,List<String> Lists,String digits){
        //首先要判断当前字段长度  如果正好等于输入的长度直接将该字段添加到Lists中
        if(stringBuilder.length()==digits.length()){
            Lists.add(stringBuilder.toString());
            return;
        }
        //然后是具体逻辑分析
        //输入字段中一个数字代表三个字母  所以先获取数字 在获取对应字母
        int input=digits.charAt(stringBuilder.length())-'0';//一开始stringbuilder为空 所以获取index=0上的元素 转化成数字
        String str=KEYS[input];//获取对应字母
        //最后是遍历添加 每个添加中是递归调用
        for (char ch : str.toCharArray()) {
            stringBuilder.append(ch);
            Combination_num(stringBuilder,Lists,digits);// 假设只有两个按键 ch+" "这句话彻底执行完时stringBuilder长度正好为1
            stringBuilder.deleteCharAt(stringBuilder.length()-1);//当前长度减一 替换该长度位置上的字母
        }
    }
}
