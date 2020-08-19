package 二叉树;

import Util.TreeNode;

public class 二叉树是否对称 {
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null){//空结点也对称
            return true;
        }
        return isMirror(pRoot.left,pRoot.right);
    }
    public boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
}
