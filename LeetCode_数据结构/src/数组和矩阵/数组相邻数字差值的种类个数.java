package 数组和矩阵;
//题目描述：数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
public class 数组相邻数字差值的种类个数 {
    public static void main(String[] args) {
        int []arr=constructArray(6,4);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    //首先让K+1个数字构成k个不同的差值1、2、3...k，然后再将后面所有的差值置为1
    public static int[] constructArray(int n, int k) {
        int []arr=new int[n];
        arr[0]=1;//将第一个值设为1
        //先将前k+1个数填充完毕   1,k+1,2,k,3,k-1,4....k/2,k/2+1
        for(int i=1,change=k;i<=k;i++,change--){//change表示的是差值，不能持续增大，需要大-小-大-小变换
            arr[i]=i%2==1?arr[i-1]+change:arr[i-1]-change;
        }
        //然后剩下的数将他们正常排列即可
        //k+2,k+3,k+4...之所以可以这么写 是因为k+2-k/2-1=k/2+1  一定是小于k的,这个差值已经在前面出现过了
        for(int i=k+1;i<n;i++){
            arr[i]=i+1;
        }
        return arr;
    }
}
