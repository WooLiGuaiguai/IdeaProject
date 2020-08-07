package 二叉树;

import Util.TreeNode;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class 前序中序重建二叉树 {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in){
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reConstructBinaryTree(int [] pre, int prestart,int preend,int [] in,int instart,int inend){
        if(prestart>preend||instart>inend){
            return null;
        }
        //首先获取一个开始结点
        TreeNode root=new TreeNode(pre[prestart]);
        for(int i=instart;i<=inend;i++){
            if(pre[prestart]==in[i]){
                root.left=reConstructBinaryTree(pre,prestart+1,prestart+1+(i-instart-1),in,instart,i-1);
                root.right=reConstructBinaryTree(pre,prestart+1+(i-instart-1)+1,inend,in,i+1,inend);
            }
        }
        return root;
    }
}
