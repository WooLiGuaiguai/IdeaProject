package 树;

import Util.TreeNode;
import sun.reflect.generics.tree.Tree;

public class 树的递归操作 {
    public static void main(String[] args) {
        int [] array={3,9,20,0,0,15,7};
        TreeNode head=null;
        TreeNode nodea=head.buildTree(array,1);
        TreeNode nodeb=head.buildTree(array,2);
        TreeNode nodec=head.buildTree(array,3);
        TreeNode noded=head.buildTree(array,4);
        TreeNode nodee=head.buildTree(array,5);
        TreeNode nodef=head.buildTree(array,6);

    }
    //14.对于一棵只有0或2个子结点的、并且父节点值小于等于子节点的二叉树 求出树中第二小的结点值
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        if(root.left==null&&root.right==null){
            return -1;
        }
        int leftMin=root.left.val;
        int rightMin=root.right.val;
        if(root.val==leftMin){
            leftMin=findSecondMinimumValue(root.left);
        }
        if(root.val==rightMin){
            rightMin=findSecondMinimumValue(root.right);
        }
        if(leftMin!=-1&&rightMin!=-1){//如果左孩子和右孩子都为空  意味着从上到该叶子结点的值都相等 那么最后肯定会返回-1
            return Math.min(leftMin,rightMin);
        }
        if(leftMin!=-1){
            //如果左子树不为-1 那么意味着左子树出现了不相等的值
            return leftMin;
        }else{
            return rightMin;
        }
    }
    //13. 间隔遍历 取结点和的最大值
    //这里需要进行比较的并不是左子树和右子树  而是从根结点开始 和不从根结点开始两种方案的大小
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        //对当前结点的操作  分为两个方案
        int val_one=root.val;
        if(root.left!=null){
            val_one=val_one+rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            val_one=val_one+rob(root.right.left)+rob(root.right.right);
        }
        int val_two=rob(root.left)+rob(root.right);
        return Math.max(val_one,val_two);
    }
    //12. 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
    public int length=0;
    public int longestUnivaluePath(TreeNode root){
        DFS_path(root);
        return length;
    }
    public int DFS_path(TreeNode  root){
        if(root==null){
            return 0;
        }
        int leftlength=DFS_path(root.left);
        int rightlength=DFS_path(root.right);
        //对于当前这个结点的操作
        int left=0,right=0;
        if(root.left!=null&&root.val==root.left.val){
            left=leftlength+1;
        }
        if(root.right!=null&&root.val==root.right.val){
            right=rightlength+1;
        }
        length=Math.max(left+right,length);
        //下一个结点需要向上一个结点返回的内容：   假如对于一个节点来说left是左子树中最长的长度right是右子树最长长度
        return Math.max(left,right);
    }
    //11.计算给定二叉树的所有左叶子之和。
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){return 0;}
        if(isLeaf(root.left)){//如果左孩子是叶子结点
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);

    }
    public boolean isLeaf(TreeNode root){
        if(root==null){
            return false;
        }
        return root.left==null&&root.right==null;//判断是否是叶子结点
    }
    //10.给定一个二叉树，找出其最小深度。 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    public int minDepth(TreeNode root) {
        if (root==null){return 0;}
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if (left==0||right==0){//处理只有左子树或只有右子树的情况
            return left+right+1;
        }
        return Math.min(left,right)+1;
    }
    //9.判断是否是镜像二叉树   空节点也是镜像二叉树
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
    //8.判断一棵树是不是另一棵树的子树  和第七题类似一点在于处理的结点还是三个
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t)||isSubtreeTest(s,t);
    }
    public boolean isSubtreeTest(TreeNode s, TreeNode t){
        //1.结束条件
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        //2.递归  如果相同的话
        return isSubtreeTest(s.left,t.left)&&isSubtreeTest(s.right,t.right);//左右子树必须完全一样
    }
    //7.找出路径和等于给定数值的路径总数。
    //路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    //难点在于第二行的要求  这意味着要处理根结点  左孩子 右孩子 ：
    // 以当前节点作为头结点的路径数量   以当前节点的左孩子作为头结点的路径数量  以当前节点的右孩子作为头结点啊路径数量
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return pathSum(root.left,sum)+pathSum(root.right,sum)+pathSumStartwithEnd(root,sum);
    }
    public int pathSumStartwithEnd(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        int result=0;
        sum=sum-root.val;
        if(sum==0){
            result=1;
        }
        return result+pathSumStartwithEnd(root.left,sum)+pathSumStartwithEnd(root.right,sum);
    }
    //6.给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==sum){//这是判断当前结点成立的条件
            return true;
        }
        sum=sum-root.val;
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
    //5.合并二叉树
    //这种递归的精髓 我觉得在于在一个递归函数中先处理自己当前结点的值的操作  再处理他的左右子树的操作 最终应该返回这个子树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }
        if(t1==null){ return t2; }
        if(t2==null){ return t1; }
        TreeNode newNode=new TreeNode(t1.val+t2.val);
        newNode.left=mergeTrees(t1.left,t2.left);
        newNode.right=mergeTrees(t1.right,t2.right);
        return newNode;
    }
    //4. 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.right;
        root.right=invertTree(root.left);
        root.left=invertTree(temp);
        return root;
    }
    //3.给定一棵二叉树，计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
    //理解为一个节点的左右两个子树的高度之和+1
    public int max=0;//用来存储最长直径
    public int diameterOfBinaryTree(TreeNode root) {
        Depth(root);
        return max;
    }
    public int Depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Depth(root.left);
        int right=Depth(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
        //拿层次遍历得到的12345来说  当遍历到4的时候 没有叶子结点left=right=0而这算一个高度 所以加一
    }
    //2.判断是否是平衡二叉树
    //就是判断一个节点两侧树的高度之差是否大于1
    public boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        MaxDepth(root);
        return flag;
    }
    public int MaxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=MaxDepth(root.left);
        int right=MaxDepth(root.right);
        if(Math.abs(left-right)>1){
            flag=false;
        }
        return Math.max(left,right)+1;
    }
    //1.树的高度
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
