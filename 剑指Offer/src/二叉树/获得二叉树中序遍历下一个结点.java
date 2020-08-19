package 二叉树;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;//父亲节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class 获得二叉树中序遍历下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        //第一种情况 如果结点的右孩子不为null  那么右子树的最左边结点就是下一个结点
        if(pNode.right!=null){
            TreeLinkNode node=pNode.right;
            while(node.left!=null){
                node=node.left;
            }
            return node;
        }
        //第二种情况  右孩子为空，那么向上查找，找到第一个 结点的左子树包含pNode结点的祖先结点就是目标结点
        else{
            while(pNode.next!=null){
                TreeLinkNode parent=pNode.next;//父亲节点
                if(parent.left==pNode){
                    return parent;
                }
                pNode=pNode.next;
            }
        }
        return null;
    }
}
