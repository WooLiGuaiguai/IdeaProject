package 二叉树;

import Util.TreeNode;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class 二叉搜索树转化成双向链表 {
    //考虑使用中序遍历
    private TreeNode pre=null;
    private TreeNode head=null;//保存头结点
    public TreeNode Convert(TreeNode pRootOfTree){
        convert(pRootOfTree);
        return head;
    }
    public void convert(TreeNode root){
        if(root==null){
            return;
        }
        convert(root.left);
        root.left=pre;//左孩子设置为前驱结点
        if(pre!=null){//前驱结点不为空  将前驱结点的next指向当前结点（双向链表）
            pre.right=root;
        }
        pre=root;//如果前驱结点为空，将当前结点设置为其前驱结点 例如 最左下角一个点的pre为null
        if(head==null){
            head=root;
        }
        convert(root.right);
    }
}
