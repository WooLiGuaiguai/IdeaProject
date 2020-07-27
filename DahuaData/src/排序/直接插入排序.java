package 排序;

public class 直接插入排序 {
    public static void main(String[] args) {
        int []arr={9,1,5,8,3,7,4,6,2};
        InsertSort(arr);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    public static void InsertSort(int []arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                int j=i;//用来移动的指针  标记需要移动的下标
                while(j>0&&temp<arr[j-1]){
                    arr[j]=arr[j-1];//向后移动 赋值给下一位
                    j--;
                }
                arr[j]=temp;//找到需要插入的位置
            }
        }
    }
}
