package 查找;

import java.util.Arrays;

public class 斐波那契查找 {
    public static void main(String[] args) {
        int []arr={1,16,24,35,47,59,62,73,88,99};
        System.out.println(find_F(arr,62));
    }
    public static int find_F(int []array,int key){
        int []F={0,1,1,2,3,5,8,13,21};
        int left=0,right=array.length-1;
        int mid=0;
        int i=0;//遍历的指针
        while(array.length>F[i]-1){//计算arr的长度在F数组中的位置    i=6
            i++;//i=7
        }
        //利用Java工具类Arrays 构造新数组并指向 数组 arr[]
        int[] arr= Arrays.copyOf(array, F[i]);
        for(int k=arr.length-1;k<F[i]-1;k++){//数列后面补全       {1,16,24,35,47,59,62,73,88,99   99,99}
            arr[k]=arr[arr.length-1];
        }
        while(left<=right){
            mid=left+F[i-1]-1;
            // 全部元素=前部元素+后部元素   f[i]=f[i-1]+f[i-2]
            // 因为前部有f[i-1]个元素,所以可以继续拆分f[i-1]=f[i-2]+f[i-3]
            // 即在f[i-1]的前部继续查找 所以i--   即下次循环 mid=f[i-1-1]-1
            if(arr[mid]>key){//在数列的前部分
                right=mid-1;
                i--;
            }else if(arr[mid]<key){
                left=mid+1;
                i=i-2;
            }else{
                if(mid<=arr.length-1){//找到的时候如果没超出原来的数组就返回  当mid位于新增的数组中时，返回n
                    return mid;
                }else{
                    return arr.length-1;
                }
            }
        }
        return 0;
    }
}
