package 树;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 树的前中后序遍历 {
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        // 标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
        TreeNode pre = root;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //访问当前结点
            root=stack.peek();
            //已经知道该节点没有左孩子，现在判断有没有右子树  同时判断是不是从右子树遍历过来的 如果是就别遍历了
            if(root.right!=null&&root.right!=pre) {
                root=root.right;
            }else{
                root= stack.pop();//弹出栈顶元素
                list.add(root.val);//遍历栈顶元素
                //将pre指向当前结点  重置root 防止右孩子重复遍历:有一种可能是if后的root和else后的root指向的都是右孩子
                //不为空的情况下会在前面的while中被压栈两次
                pre=root;
                root=null;
            }
        }
        return  list;
    }
    //前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
    //可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        if(root==null){
            return list;
        }
        while(!stack.isEmpty()||root!=null){
            while(root!=null){//如果当前结点不为空  一直找到最左侧结点
                stack.push(root);
                root=root.left;
            }
            //对当前结点进行操作：
            //现在root为空,意味着左孩子访问为空  该访问当前结点了，所以弹出刚入栈的；然后再继续访问它的右孩子
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
}
