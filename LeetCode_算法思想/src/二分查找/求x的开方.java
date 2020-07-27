package 二分查找;

public class 求x的开方 {
    public static void main(String[] args) {
        System.out.println(mySqrt(6));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));

    }
    public static int mySqrt(int x){
        if (x<=1){
            return x;
        }
        int left=0,right=x;
        while (left<=right){
            int mid=left+(right-left)/2;
            int sqrt=x/mid;
            if(sqrt==mid){
                return mid;
            }else if(sqrt<mid){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return right;//不整除
    }
}
