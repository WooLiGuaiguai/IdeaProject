package LeetCode_算法思想.src.Util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode buildTree(int []arr,int index){
        TreeNode node=null;
        if(index>arr.length){
            return null;
        }
        node=new TreeNode(arr[index-1]);
        node.left= buildTree(arr,2*index);
        node.right= buildTree(arr,2*index+1);
        return node;
    }
}
