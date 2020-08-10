package 数组;

public class 数组中的逆序对 {
    private int count=0;
    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        MergeSort(array,0,array.length-1);
        return count;
    }
    public void MergeSort(int []array,int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        MergeSort(array,start,mid);
        MergeSort(array,mid+1,end);
        MergeOne(array,start,mid,end);
    }
    public void MergeOne(int []array,int start,int mid,int end){
        int []temp=new int[end-start+1];
        int k=0;//temp指针下标
        int i=start,j=mid+1;//此时合并的两个数组已经排序完成 都是递增的
        while(i<=mid && j<=end){
            if(array[i]<=array[j]){//没有办法构成逆序对
                temp[k++]=array[i++];//直接将该数字放进数组
            }else{
                temp[k++]=array[j++];//array[i]后面的元素都大于array[j]
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                count=(count+(mid-i+1))%1000000007;
            }
        }
        while(i<=mid){//j<=end不成立了
            temp[k++] = array[i++];
        }
        while(j<=end){
            temp[k++] = array[j++];
        }
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];
        }
    }

    public static void main(String[] args) {
        数组中的逆序对 classone=new 数组中的逆序对();
        int []array={1,2,3,4,5,6,10,9,8,7,4,21,0};
        System.out.println(classone.InversePairs(array));
    }
}
