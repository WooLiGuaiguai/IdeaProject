package 排序;

public class 归并排序 {
    public static void main(String[] args) {
        int []arr={9,1,5,8,3,7,4,6,2};
        MergeSort(arr,0,arr.length-1);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    public static  void MergeSort(int []arr,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            MergeSort(arr,start,mid);
            MergeSort(arr,mid+1,end);
            Merge(arr,start,mid,end);
        }
    }
    public static void Merge(int []arr,int start,int mid,int end){
        int []temp=new int[end-start+1];
        for(int i=start;i<=end;i++){
            temp[i-start]=arr[i];
        }
        int k=0;        //临时区域的指针
        int i=start;    //第一个有序区的指针
        int j=mid+1;    //第二个有序区的指针

        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while(i<=mid)
            temp[k++]=arr[i++];
        while(j<=end)
            temp[k++]=arr[j++];

        for(k=0;k<=end-start;k++)
            arr[k+start]=temp[k];
    }
}
