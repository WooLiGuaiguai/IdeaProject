package 树;

import Util.ListNode;
import Util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

//二叉查找树（BST）：根节点大于等于左子树所有节点，小于等于右子树所有节点。
//二叉查找树中序遍历有序。
public class BST {
    //10.给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素
    TreeNode prenode=null;
    int count=1;
    int maxcount=1;
    public int[] findMode(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inorder_time(root,list);
        int [] zhongshu=new int[list.size()];
        int i=0;
        for(int item:list){
            zhongshu[i]=item;
            i++;
        }
        return zhongshu;
    }
    //中序遍历将出现频率最高的值添加到集合中
    public void inorder_time(TreeNode root,List<Integer> list){
        if(root==null){return;}
        inorder_time(root.left,list);
        if(prenode!=null){//判断当前结点
            if(prenode.val==root.val){
                count++;
            }else {
                count=1;
            }
        }
        if(count>maxcount){
            maxcount=count;
            list.clear();
            list.add(root.val);
        }else if(count==maxcount){
            list.add(root.val);
        }
        prenode=root;
        inorder_time(root.right,list);
    }
    //9.给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
    int min=Integer.MAX_VALUE;
    TreeNode pre=null;
    public int getMinimumDifference(TreeNode root) {
        min_Cha(root);
        return min;
    }
    public void min_Cha(TreeNode root){
        if(root==null){
            return;
        }
        min_Cha(root.left);
        if(pre!=null){
            min=Math.min(min,root.val-pre.val);
        }
        pre=root;
        min_Cha(root.right);
    }
    //8.给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        inorder_digui(root,list);//中序遍历得到的有序集合
        int left=0,right=list.size()-1;
        while(left<right){
            if(list.get(left)+list.get(right)==k){
                return true;
            }else if(list.get(left)+list.get(right)>k){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
    public void inorder_digui(TreeNode root,List<Integer> list){
        if(root==null){return;}
        inorder_digui(root.left,list);
        list.add(root.val);
        inorder_digui(root.right,list);
    }
    //7.给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode find=findMid(head);
        ListNode mid=find.next;//如果是奇数个 这时候找到的find是中间那个  如果是偶数个保存的是n/2 为了好构建树，取find下一个为root
        TreeNode root=new TreeNode(mid.val);
        ListNode right=mid.next;//保存要实现的右孩子结点
        find.next=null;//断开链表
        root.right=sortedListToBST(right);
        root.left=sortedListToBST(head);
        return root;
    }
    //查找链表中心点
    public ListNode findMid(ListNode head){
        ListNode left=head;
        ListNode right=head.next;
        ListNode mid=head;
        while(right!=null&&right.next!=null){
            mid=left;//存储left临时结点  当结束遍历是left所在的位置就是mid位置
            left=left.next;
            right=right.next.next;
        }
        return mid;
    }

    //6. 根据有序数组建立二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums,0,nums.length-1);
    }
    public TreeNode toBST(int[] nums,int start,int end) {
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=toBST(nums,start,mid-1);
        root.right=toBST(nums,mid+1,end);
        return root;
    }
    //5.给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;//找到  或者  已经查找到最下面
        }
        TreeNode leftIsExist=lowestCommonAncestor2(root.left,p,q);
        TreeNode rightIsExist=lowestCommonAncestor2(root.right,p,q);
        //获取了左右子树中的最上层的祖先
        //如果左侧为空  直接返回右侧；
        //如果左侧不为空，判断右侧：如果右侧也不为空，返回当前结点；如果右侧也为空，直接返回左侧
        return leftIsExist==null?rightIsExist:rightIsExist==null?leftIsExist:root;
    }
    //4.给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    //从根节点开始遍历，如果p q的值都大于root，那么在他的右子树查找；都小于，在左子树查找；否则当前结点就是需要的结点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){return null;}
        while(root!=null){
            if(root.val>p.val&&root.val>q.val){
                root=lowestCommonAncestor(root.left,p,q);
            }else if(root.val<p.val&&root.val<q.val){
                root=lowestCommonAncestor(root.right,p,q);
            }else{
                return root;
            }
        }
       return root;
    }
    //3. 给定一个二叉搜索树，把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        order(root);//对节点的值进行操作
        return root;
    }
    public void order(TreeNode root){
        if(root==null){return;}
        order(root.right);
        sum=sum+root.val;//前面的和加上当前结点的值 并重新赋值给当前结点
        root.val=sum;
        order(root.left);
    }
    //2.给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
    List<Integer>list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        for(int i=0;i<k;i++){
            if(i==k-1){
                return list.get(i);
            }
        }
        return 0;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    //上题第二种递归方法：
    int value=0;
    public int kthSmallest2(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        if(count(root.left)==(k-1)){
            return root.val;
        }
        if(count(root.left)<k-1){
            return kthSmallest2(root.right,k-count(root.left)-1);
        }
        return kthSmallest2(root.left,k);
    }
    public int count(TreeNode node){
        if(node==null){return 0; }
        return 1+count(node.left)+count(node.right);
    }
    //上述中序遍历解法二
    private int cnt = 0;
    private int val;
    public int kthSmallest3(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }
    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }

    //给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
    //通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L)
    //你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){return root;}
        if(root.val>R){
            return trimBST(root.left,L,R);
        }
        if(root.val<L){
            return trimBST(root.right,L,R);
        }
        root.left=trimBST(root.left,L,R);
        root.right=trimBST(root.right,L,R);
        return root;
    }

}
