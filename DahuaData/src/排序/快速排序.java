package 排序;

public class 快速排序 {
    public static void main(String[] args) {
        int []arr={5,8,3,7,4,6,2,1,9};
        QSort(arr);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    public static void QSort(int []arr){
        QuickSort(arr,0,arr.length-1);
    }
    public static void QuickSort(int []arr,int low,int high){
        if(low<high){
            int pivot=Partition(arr,low,high);
            QuickSort(arr,low,pivot-1);
            QuickSort(arr,pivot+1,high);
        }
    }
    public static int Partition(int []arr,int low,int high){
        int temp=arr[low];
        while(low<high){
            while(low<high && arr[high]>temp){
                high--;
            }
            arr[low]=arr[high];
            while(low<high && arr[low]<temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
