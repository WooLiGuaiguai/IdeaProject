package 树;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//迭代就是通过循环 将上一次的运行结果传递给下一次操作
public class 树的迭代操作 {
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            //跳出循环的条件
            //当前结点都为空的时候 应该结束这次循环 继续遍历；有一个为空或值不相同的时候直接返回false
            if(t1==null&&t2==null){continue;}
            if(t1==null||t2==null){return false;}
            if(t1.val!=t2.val){return false;}
            //两两比较 所以取出来判断的是两个 那么临近存进去的应该也是要进行比较的两个
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

}
