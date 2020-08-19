package 二叉树;

import Util.TreeNode;

//给定一棵二叉搜索树，请找出其中的第k小的结点。
//例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
public class 二叉搜索树的第k个结点 {
    int count=0;
    TreeNode KthNode(TreeNode pRoot, int k){
        //使用中序遍历思想
        if(pRoot!=null){
            TreeNode node=KthNode(pRoot.left,k);
            if(node!=null){
                return node;
            }
            count++;
            if(count==k){
                return pRoot;
            }
            TreeNode node1=KthNode(pRoot.right,k);
            if(node1!=null){
                return node1;
            }
        }
        return null;
    }
}
