package 二叉树;

import Util.TreeNode;

import java.util.ArrayList;

//输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class 二叉树中和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
         findPath(root,target,new ArrayList<>());
         return lists;
    }

    public void findPath(TreeNode root,int target,ArrayList<Integer> path) {
        if(root==null){
            return ;
        }
        //将当前结点添加进来
        path.add(root.val);
        target=target-root.val;
        //是否符合从根结点到叶子结点 并且target满足路径和
        if(target==0 && root.left==null&&root.right==null){
            lists.add(new ArrayList<>(path));
        }else{
            findPath(root.left,target,path);
            findPath(root.right,target,path);
        }
        //找到一条路径之后，需要晦朔到上一个节点接着查找
        //例如，else中遍历完左孩子之后假如该路径添加到lists中，接着需要遍历右子树
        //而这时候需要把左孩子去掉节点遍历，所以remove
        path.remove(path.size()-1);
    }
}
