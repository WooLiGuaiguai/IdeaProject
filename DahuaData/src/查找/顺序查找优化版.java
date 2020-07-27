package 查找;

public class 顺序查找优化版 {
    public static void main(String[] args) {
        int []arr={1000,1,2,3,4,5};
        System.out.println(search(arr,5,0));
    }
    public static int search(int []arr,int n,int k){
        arr[0]=k;
        int i=n;//遍历的指针
        while(arr[i]!=k){
            i--;
        }
        return i;
    }
}
