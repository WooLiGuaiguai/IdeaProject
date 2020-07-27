package 排序;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class 堆排序 {
    public static void main(String[] args) {
        int []arr={9,1,5,8,3,7,4,6,2};
        HeapSort(arr,9);
        int []brr={1,2,3};
        //HeapSort(brr,3);

    }
    public static void BuildMaxHeap(int []arr,int len){
        for(int i=len/2-1;i>=0;i--){
            AdjustDown(arr,i,len-1);
            //AdjustUp(arr,len-1);
        }
    }
    /*public static void AdjustUp(int []arr,int start){//将元素start向上移动
        int temp=arr[start];
        int i=start/2-1;//双亲结点
        while(i-1>=0&&arr[i]<temp){
            arr[start]=arr[i];
            start=i;
            i=start/2-1;
        }
        arr[start]=temp;
    }*/
    public static void AdjustDown(int []arr,int start,int end){//将元素k向下调整  将start到end整成堆
        int temp=arr[start];//保存根结点值
        for(int i=2*start+1;i<=end;i=i*2+1){
            if(i+1<=end && arr[i]<arr[i+1]){//防止访问arr[i+1]越界
                i++;//始终指向要进行交换的孩子结点
            }
            if(temp>=arr[i]){
                break;
            }else{
                arr[start]=arr[i];
                start=i;//继续向下遍历 防止上面的变动导致下面的变动
            }
        }
        arr[start]=temp;
    }
    public static void HeapSort(int []arr,int len){
        BuildMaxHeap(arr,len);
        //输出堆顶元素
        for(int i=len-1;i>=0;i--){
            swap(arr,i,0);
            System.out.print(arr[i]+" ");
            AdjustDown(arr,0,i-1);
            //AdjustUp(arr,i-1);
        }
    }
    public static void swap(int []data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
