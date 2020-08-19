package 二叉树;
//按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
import Util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class 之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(pRoot==null){
            return lists;
        }
        boolean reverse=true;
        queue.add(pRoot);
        int count=0;//统计每层加入栈的结点数
        while(!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            count=queue.size();
            while(count>0){
                TreeNode node=queue.poll();
                list.add(node.val);
                count--;
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
            }
            if(reverse){
                Collections.reverse(list);
            }
            reverse=!reverse;
            if(list.size()!=0){
                lists.add(list);
            }
        }
        return lists;
    }
}
