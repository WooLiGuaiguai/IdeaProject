package 二叉树;
public class chongjianerchashu {
    public static void main(String[] args) {
        int []a={1,2,4,7,3,5,6,8};
        int []b={4,7,2,1,5,3,8,6};
        reConstructBinaryTree(a,b);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reset(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reset(int []pre,int pstart,int pend,int []in,int istart,int iend){
        if(pstart>pend||istart>iend){
            return null;
        }
        //首先要获取一个遍历开始结点
        TreeNode root=new TreeNode(pre[pstart]);
        for(int i=istart;i<=iend;i++){
            if (pre[pstart]==in[i]){
                //获得左子树的根结点  也就是上一级根结点的左孩子  i-1-istart是左子树的长度
                root.left=reset(pre,pstart+1,pstart+1+(i-1-istart),in,istart,i-1);
                //右子树的pstart=左子树的pend+1
                root.right=reset(pre,pstart+1+(i-1-istart)+1,pend,in,i+1,iend);
            }
        }
        return root;
    }
}
