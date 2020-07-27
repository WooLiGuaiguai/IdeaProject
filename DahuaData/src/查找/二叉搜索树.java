package 查找;
class Node{
    int data;
    Node lChild;
    Node rChild;

    public Node(int data){
        this.data=data;
        lChild=null;
        rChild=null;
    }
}
public class 二叉搜索树 {

    private Node root;
    public 二叉搜索树(){
        this.root=null;
    }
    //查找最小结点  返回以root为根的二叉树的最小结点
    public Node find_min(Node root){
        if(root==null){
            return null;
        }
        while(root.lChild!=null){
            root=root.lChild;
        }
        return root;
    }
    //查找最大结点  返回以root为根的二叉树的最大结点
    public Node find_max(Node root){
        if(root==null){
            return null;
        }
        while(root.rChild!=null){
            root=root.rChild;
        }
        return root;
    }
    //查找
    public boolean SearchBST(Node root,int key){
        if(root==null){
            return false;
        }
        while(root!=null){
            if(root.data==key){
                return true;
            }else if(root.data>key){
                root=root.lChild;
            }else{
                root=root.rChild;
            }
        }
        return false;
    }
    //插入
    public Node InsertBST(Node root,int key){
        if (root == null) {
            return new Node(key);
        }
        if (key == root.data) {
            return root;
        } else if (key < root.data) {
            root.lChild=InsertBST(root.lChild, key);
        } else {
            root.rChild=InsertBST(root.rChild, key);
        }
        return root;
    }
    //删除
    public boolean deleteBST(Node root,int key){
        if(root==null){
            return false;
        }
        Node parent=null;//用来保存父节点
        Node pnext=root;//用来移动  保存孩子结点
        while(pnext!=null){
            if(pnext.data==key){
                delete(pnext,parent);
                return true;
            }else if(pnext.data>key){
                parent=pnext;
                pnext=pnext.lChild;
            }else{
                parent=pnext;
                pnext=pnext.rChild;
            }
        }
        return false;
    }
    public void delete(Node pnext,Node parent){//前面是被删除结点  后面是父结点
        if(pnext.lChild==null){//左子树为空
            if(pnext==root){//被删除是根结点
                root=root.rChild;
                pnext=null;
            }else{
                if(pnext.data<parent.data){//被删除结点是左孩子节点
                    parent.lChild=pnext.rChild;//将它的右孩子接在父节点的左孩子上
                    pnext=null;
                }else{
                    parent.rChild=pnext.rChild;
                    pnext=null;
                }
            }
        }else if(pnext.rChild==null){//右子树为空
            if(pnext==root){//被删除是根结点
                root=root.lChild;
                pnext=null;
            }else{
                if(pnext.data<parent.data){//被删除结点是左孩子节点
                    parent.lChild=pnext.lChild;//将它的右孩子接在父节点的左孩子上
                    pnext=null;
                }else{
                    parent.rChild=pnext.lChild;
                    pnext=null;
                }
            }
        }else{//左右子树都不为空   删除的地方使用前驱结点代替
            Node pre,node;
            node=pnext;
            pre=pnext.lChild;//保存左子树
            while(pre.rChild!=null) {//找左子树最大结点   也就是最大的前驱
                node=pre;
                pre=pre.rChild;
            }
            pnext.data=pre.data;
            if(node!=pnext){
                node.rChild=pre.lChild;
            }else{
                node.lChild=pre.lChild;
            }
            node=null;
        }
    }
    //遍历
    public void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.lChild);
        System.out.print(node.data+" ");
        inorder(node.rChild);
    }

    public static void main(String[] args) {
        二叉搜索树 BinaryTree=new 二叉搜索树();
        System.out.println("根结点：");
        Node root=new Node(4);
        BinaryTree.inorder(root);
        System.out.println(" ");

        System.out.println("插入新的结点：");
        root=BinaryTree.InsertBST(root,5);
        root=BinaryTree.InsertBST(root,6);
        root=BinaryTree.InsertBST(root,7);
        root=BinaryTree.InsertBST(root,2);
        root=BinaryTree.InsertBST(root,2);//重复结点
        BinaryTree.inorder(root);
        System.out.println(" ");

        System.out.println("查询结点：");
        System.out.println(BinaryTree.SearchBST(root,8));
        System.out.println("删除结点：");
        System.out.println(BinaryTree.deleteBST(root,6));
        BinaryTree.inorder(root);
    }
}
