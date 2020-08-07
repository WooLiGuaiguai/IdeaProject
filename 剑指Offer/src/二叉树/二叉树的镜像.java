package 二叉树;

import Util.TreeNode;

import java.util.Stack;

public class 二叉树的镜像 {
    //递归实现
    public void Mirror(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
    //使用栈实现
    public void Mirror2(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null||node.right!=null){
                TreeNode temp=node.left;
                node.left=node.right;
                node.right=temp;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
    }
}
