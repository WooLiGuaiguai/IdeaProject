package 分治;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class 不同的二叉搜索树 {
    public static void main(String[] args) {

    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> list=new LinkedList<>();
        if(start>end){
            list.add(null);//这颗子树为空  添加null并返回此树
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=generateTrees(start,i-1);
            List<TreeNode> right=generateTrees(i+1,end);
            //左右子树组合方式
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    list.add(root);//把一棵树的根结点直接添加进来了
                }
            }
        }
        return list;
    }
}
