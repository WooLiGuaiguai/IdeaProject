package Tree.Binary_tree;


import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Binary_tree {
    private TreeNode root;
    private TreeNode prenode;
    class TreeNode{
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private boolean ltag;
        private boolean rtag;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLtag() {
            return ltag;
        }

        public void setLtag(boolean ltag) {
            this.ltag = ltag;
        }

        public boolean isRtag() {
            return rtag;
        }

        public void setRtag(boolean rtag) {
            this.rtag = rtag;
        }

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.ltag=false;
            this.rtag=false;
        }
    }
    //二叉线索树的构造函数
    public Binary_tree(){
        root=null;
        prenode=null;
    }
    public Binary_tree(int []array){
        prenode=null;
        root=buildTree(array,1);
    }
    //创建二叉树
    public TreeNode buildTree(int []arr,int index){
        TreeNode node=null;
        if(index>arr.length){
            return null;
        }
        node=new TreeNode(arr[index-1]);
        node.leftChild = buildTree(arr,2*index);
        node.rightChild = buildTree(arr,2*index+1);
        return node;
    }
    //求二叉树的高度
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int i=getHeight(root.leftChild);
            int j = getHeight(root.rightChild);
            return i >= j ? i + 1 : j + 1;
        }
    }
    //求二叉树的结点数
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.leftChild) + getSize(root.rightChild);
        }
    }
    //前序非递归遍历
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            System.out.println("空树");
            return;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.print(node.data+" ");
            //如果栈顶元素的右孩子不为空，则进栈
            if(node.rightChild!=null){
                stack.push(node.rightChild);
            }
            //如果栈顶元素的左孩子不为空，则进栈
            if(node.leftChild!=null) {
                stack.push(node.leftChild);
            }
        }
    }
    //中序非递归遍历  并保存在集合中返回
    public List<Integer> inOrder(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){//如果当前结点不为空，那么开始以他为根进行遍历
                stack.push(root);
                root=root.leftChild;
            }
            root=stack.pop();//当前结点
            list.add(root.data);
            root=root.rightChild;
        }
        return list;
    }
    //后序非递归遍历
    public List<Integer> postOder(TreeNode root){
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
                root=root.leftChild;
            }
            //访问当前结点
            root=stack.peek();
            //已经知道该节点没有左孩子，现在判断有没有右子树
            if(root.rightChild!=null&&root.rightChild!=pre) {
                root=root.rightChild;
            }else{
                root= stack.pop();//弹出栈顶元素
                list.add(root.data);//遍历栈顶元素
                //将pre指向当前结点  防止右孩子重复遍历:有一种可能是if后的root和else后的root指向的都是右孩子
                //不为空的情况下会在前面的while中被压栈两次
                pre=root;
                root=null;//如果不重置，跳出这个if else之后再while循环中又会将该root压栈
            }
        }
        return  list;
    }
    //层次遍历
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return null;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();//用来判断这一层是否遍历完
            List<Integer> list=new ArrayList<>();
            while(size!=0){
                TreeNode node=queue.poll();
                size--;
                if(node.leftChild!=null){
                    queue.add(node.leftChild);
                }
                if(node.rightChild!=null){
                    queue.add(node.rightChild);
                }
                list.add(node.data);
            }
            lists.add(list);
        }
        return lists;
    }
    //复制一颗二叉树
    public TreeNode copyTree(TreeNode root){
        if(root==null){
            return null;
        }
        //构造根结点
        TreeNode NewRoot=new TreeNode(root.data);
        NewRoot.leftChild=copyTree(root.leftChild);
        NewRoot.rightChild=copyTree(root.rightChild);
        return NewRoot;
    }
    //判断两棵树是否相同
    public boolean equal_tree(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1!=null&&node2!=null){
            if(node1.data==node2.data){
                return equal_tree(node1.leftChild,node2.leftChild)&&equal_tree(node1.rightChild,node2.rightChild);
            }
        }
        return false;
    }
    //前序遍历构建二叉树
    //前序中序遍历二叉树
    //中序线索化创建二叉树
    public void inThreadTree(TreeNode root){
        if(root!=null){
            inThreadTree(root.leftChild);
            if(root.leftChild==null){
                root.ltag=true;
                root.setLeftChild(prenode);
            }
            if(prenode!=null&&prenode.rightChild==null){
                prenode.rtag=true;
                prenode.setRightChild(root);
            }
            prenode=root;
            inThreadTree(root.rightChild);
        }
    }
/*
      1
   2    3
 4  5  6
  */
    public static void main(String[] args) {
        Binary_tree tree=new Binary_tree();
        int [] array={1,2,3,4,5,6};
        TreeNode nodea=tree.buildTree(array,1);
        TreeNode nodeb=tree.buildTree(array,2);
        TreeNode nodec=tree.buildTree(array,3);
        TreeNode noded=tree.buildTree(array,4);
        TreeNode nodee=tree.buildTree(array,5);
        TreeNode nodef=tree.buildTree(array,6);
        tree.preOrder(nodea);
        System.out.println();
        System.out.println(tree.inOrder(nodea));
        System.out.println(tree.postOder(nodea));
        System.out.println(tree.levelOrder(nodea));
        TreeNode node_copy=tree.copyTree(nodea);
        System.out.println(tree.postOder(node_copy));
        System.out.println(tree.equal_tree(node_copy,nodea));


    }
}
