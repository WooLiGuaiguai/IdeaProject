package cn.ccTengx.day0223;

public class Practices {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static long count=0;
    private static int []temp;
    public static void main(String[] args) {
        int []arr={7,5,6,4};
        System.out.println(InversePairs(arr));

    }
    public static int InversePairs(int[] nums){
        temp=new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return (int)(count%1000000007);
    }
    public static void mergeSort(int []nums,int start,int end){
        if(end-start<1){return;}
        int mid=(start + end) / 2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    public static void merge(int []nums,int start,int mid,int end){
        int i=start,j=mid+1,k=start;
        while(i<=mid||j<=end){
            if(i>mid) {//前面半个数组已经遍历完了
                temp[k]=nums[j];
                j++;
            }else if(j>end){//后面的数组已经遍历完了
                temp[k]=nums[i];
                i++;
            }else if(nums[i]<=nums[j]){
                temp[k]=nums[i];
                i++;
            }else {//前面大于后面 属于逆序
                temp[k]=nums[j];
                j++;
                //nums[i]>nums[j] 前面已经是升序  所以意味着从i到mid每个数都大于j处数值
                count=count+(mid-i+1);
            }
            k++;
        }
        for(k=start;k<=end;k++){
            nums[k]=temp[k];
        }
    }
    int index = 0;
    TreeNode Deserialize(String str) {
        TreeNode node=null;
        if(str==null||str.length()==0){
            return node;
        }
        int start=index;
        while(str.charAt(index)!=','){
            index++;//因为每个数字或$使用逗号隔开 可能存在多位数字
        }
        if(!str.substring(start,index).equals("$")){//空指针序列化转换成$
            //这时候index指向的位置上是逗号
            node=new TreeNode(Integer.parseInt(str.substring(start,index)));
            index++;//向后移动 我们开始找左孩子结点，前序遍历 一个结点的后两个结点是左右孩子结点
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }else{//如果是$ 也就是空字符串也不碍事 接着往后走
            index++;
        }
        return node;
    }
}
