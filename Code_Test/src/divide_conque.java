import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}
public class divide_conque {
    public static void main(String[] args) {
        String str="2*3-4*5";
        List<Integer> arrays=diffWaysToCompute(str);
        for (Integer array : arrays) {
            System.out.print(array+" ");
        }

    }
    //给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
    public static List<TreeNode> generateTrees(int n) {
        if(n==0){
            return  new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }
    public static List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> list=new LinkedList<TreeNode>();//获取二叉树的所有可能  list中每个元素都是二叉树
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=generateTrees(start,i-1);
            List<TreeNode> right=generateTrees(i+1,end);
            for(TreeNode l:left){
                for (TreeNode r : right) {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    list.add(root);
                }
            }
        }
        return list;
    }
    //给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果
    //你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> arrays=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'){
                List<Integer> left=diffWaysToCompute(input.substring(0,i));
                List<Integer> right=diffWaysToCompute(input.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        switch(ch){
                            case '+':
                                arrays.add(l+r);
                                break;
                            case '-':
                                arrays.add(l-r);
                                break;
                            case '*':
                                arrays.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if(arrays.size()==0){
            arrays.add(Integer.valueOf(input));
        }
        return arrays;
    }
}
