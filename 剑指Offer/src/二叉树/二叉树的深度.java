package 二叉树;

import Util.TreeNode;

public class 二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return 1+Math.max(left,right);
    }
}
