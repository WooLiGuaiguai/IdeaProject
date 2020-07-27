package 树;

import Util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 树的层次遍历 {
    //2.给定一个二叉树，在树的最后一行找到最左边的值。
    public int findBottomLeftValue_fast(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            //从右往左添加
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int left=root.val;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean []flag=new boolean[2*size];
            int []val=new int[2*size];
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                    flag[2*i]=true;
                    val[2*i]=node.left.val;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    flag[2*i+1]=true;
                    val[2*i+1]=node.right.val;
                }
            }
            for(int i=0;i<2*size;i++){//是要遍历flag数组
                if (flag[i]==true){
                    left=val[i];//不断更新这个值  每次都是返回这一层最左侧的
                    break;
                }
            }
        }
        return left;
    }
    //1.层次遍历  求解每层结点的平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                sum=sum+node.val;
                if(node.left!=null){queue.add(node.left);}
                if(node.right!=null){queue.add(node.right);}
            }
            list.add(sum/size);
        }
        return list;
    }
}
