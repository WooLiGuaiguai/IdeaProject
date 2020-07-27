package 排序;

public class 简单选择排序 {
    public static void main(String[] args) {
        int []arr={9,1,5,8,3,7,4,6,2};
        SelectSort(arr);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    //从index=0开始，将当前的index设为min，将它后面所有值与arr[min] 比较，不断更新min的值，
    //如果最终min值发生变化，那么交换min处和index处的值 完成一次简单选择
    public static void SelectSort(int []arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(min!=i){
                swap(arr,i,min);
            }
        }
    }
    public static void swap(int []data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
