package 排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        int []arr={9,1,5,8,3,7,4,6,2};
        BubbleSort2(arr);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    //优化的冒泡排序  标志位判断是否需要遍历
    public static void BubbleSort2(int []arr){
        boolean flag=true;
        for(int i=0;i<arr.length&&flag;i++){
            flag=false;//每次开始的时候初始化 flag;如果一直是false 表示一个也没交换 已经是要求的顺序了,不需要再遍历
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                    flag=true;
                }
            }
        }
    }
    public static void BubbleSort(int []arr){
        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    public static void swap(int []data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
