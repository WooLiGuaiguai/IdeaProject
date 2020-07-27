package 查找;

public class 折半查找 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9};
        System.out.println(Binary_search(arr,5));
        System.out.println(Binary_search(arr,10));
    }
    //left=1 right=n  n为奇数 mid=中间一个；n为偶数 mid=右侧一组第一个
    public static int Binary_search(int []arr,int key){
        int size=arr.length;
        int left=0,right=size-1;
        int mid=0;
        while(left<=right){//重合的时候也要计算
            mid=(left+right)/2 ;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return 0;
    }
}
