package 二叉树;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence){
        if(sequence==null||sequence.length==0){
            return false;
        }
        return isTree(sequence,0,sequence.length-1);
    }
    public boolean isTree(int []sequence,int start,int end){
        if(end<=start){
            return true;
        }
        int i=start;
        for(;i<end;i++){//找到第一个大于最后一个节点的  跳出循环
            if(sequence[i]>sequence[end]){
                break;
            }
        }
        for(int j=i;j<end;j++){//后面的结点应该是都大于最后一个节点的
            if(sequence[j]<sequence[end]){//如果不是 直接返回错误
                return false;
            }
        }
        return isTree(sequence,start,i-1) && isTree(sequence,i,end-1);
    }
}
