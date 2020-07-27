package 查找;
class AVLNode{
    int data;
    AVLNode lChild;
    AVLNode rChild;
    int BF;

    public AVLNode(int data){
        this.data=data;
        lChild=null;
        rChild=null;
        BF=0;
    }
}
public class 二叉平衡树 {

    private AVLNode root;
    public 二叉平衡树(){
        this.root=null;
    }
    //右旋
    public AVLNode rRotate(AVLNode root){
        AVLNode newRoot=root.lChild;
        root.lChild=newRoot.rChild;
        newRoot.rChild=root;
        return newRoot;
    }
    //左旋
    public AVLNode lRotate(AVLNode root){
        AVLNode newRoot=root.rChild;
        root.rChild=newRoot.lChild;
        newRoot.lChild=root;
        return newRoot;
    }
    //左平衡旋转  左子树高度高于右子树
    public AVLNode LeftBalance(AVLNode root){
        AVLNode node=root.lChild;//要分析的是不平衡的树的根结点的左孩子的BF
        switch (node.BF){
            case 1://情况1  直接右旋
                root.BF=0;
                node.BF=0;
                return rRotate(root);
            case -1://
                AVLNode node_rChild=node.rChild;
                switch (node_rChild.BF){
                    case 1://情况2
                        root.BF=-1;
                        node.BF=0;
                        break;
                    case -1://情况3
                        root.BF=0;
                        node.BF=1;
                        break;
                    case 0://情况4
                        root.BF=0;
                        node.BF=0;
                        break;
                }
                //操作都是先左旋 后右旋
                node_rChild.BF=0;
                root.lChild=lRotate(node);
                return rRotate(root);
            case 0://情况5  删除时可能会出现
                node.BF=-1;
                root.BF=1;
                return rRotate(root);
        }
        return root;
    }
    //右平衡旋转  右子树高度高于左子树
    public AVLNode RightBalance(AVLNode root){
        AVLNode node=root.rChild;//要分析的是不平衡的树的根结点的右孩子的BF
        switch (node.BF){
            case -1://情况1  BF都是正值 直接左旋
                root.BF=0;
                node.BF=0;
                return lRotate(root);
            case 1://
                AVLNode node_lChild=node.lChild;
                switch (node_lChild.BF){
                    case 1://情况2
                        root.BF=0;
                        node.BF=-1;
                        break;
                    case -1://情况3
                        root.BF=1;
                        node.BF=0;
                        break;
                    case 0://情况4
                        root.BF=0;
                        node.BF=0;
                        break;
                }
                //操作都是先左旋 后右旋
                node_lChild.BF=0;
                root.rChild=rRotate(node);
                return lRotate(root);
            case 0://情况5  删除时可能会出现
                node.BF=1;
                root.BF=-1;
                return lRotate(root);
        }
        return root;
    }
    //查找最小结点  返回以root为根的二叉树的最小结点
    public AVLNode find_min(AVLNode root){
        if(root==null){
            return null;
        }
        while(root.lChild!=null){
            root=root.lChild;
        }
        return root;
    }
    //查找最大结点  返回以root为根的二叉树的最大结点
    public AVLNode find_max(AVLNode root){
        if(root==null){
            return null;
        }
        while(root.rChild!=null){
            root=root.rChild;
        }
        return root;
    }
    //查找
    public boolean SearchBST(AVLNode root,int key){
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
    boolean taller=false;
    public AVLNode InsertBST(AVLNode root,int key){
        if (root == null) {
            taller=true;
            return new AVLNode(key);
        }
        if (key == root.data) {
            taller=false;
            return root;
        } else if (key < root.data) {
            root.lChild=InsertBST(root.lChild, key);
            if(taller==true){//左子树长高
                switch (root.BF){
                    case 1://原先左子树比右子树高  进行左平衡处理  处理完之后高度没有增加
                        taller=false;
                        return LeftBalance(root);
                    case 0:
                        taller=true;
                        root.BF=1;
                        return root;
                    case -1:
                        taller=false;
                        root.BF=0;
                        return root;
                }
            }
        } else {
            root.rChild=InsertBST(root.rChild, key);
            if(taller==true){//右子树长高
                switch (root.BF){
                    case 1://原先左子树比右子树高  现在等高
                        taller=false;
                        root.BF=0;
                        return root;
                    case 0://原本等高 现在右边高了
                        taller=true;
                        root.BF=-1;
                        return root;
                    case -1://原本右边高
                        taller=false;
                        return RightBalance(root);
                }
            }
        }
        return root;
    }
    //删除
    /*public boolean deleteBST(AVLNode root,int key){ }
    public void delete(AVLNode pnext,AVLNode parent){//前面是被删除结点  后面是父结点 }*/
    //遍历
    public void inorder(AVLNode node){
        if(node==null){
            return;
        }
        inorder(node.lChild);
        System.out.print(node.data+" ");
        inorder(node.rChild);
    }

    public static void main(String[] args) {
        二叉平衡树 BinaryTree=new 二叉平衡树();
        System.out.println("根结点：");
        AVLNode root=new AVLNode(4);
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

    }
}
