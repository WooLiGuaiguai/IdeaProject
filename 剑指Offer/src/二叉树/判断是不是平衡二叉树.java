package 二叉树;

import Util.TreeNode;

public class 判断是不是平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root){
        if(root==null){
            return false;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.abs(left-right)<=1;
    }
    public int height(TreeNode root){
        return (root==null) ? 0 :1+Math.max(height(root.left),height(root.right));
    }
}
