package 数组;
/*复杂度分析
时间复杂度：O(log(min(m,n)))，
首先，查找的区间是 [0, m],而该区间的长度在每次循环之后都会减少为原来的一半。
所以，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 O(log(m))。
由于 m≤n，所以时间复杂度是O(log(min(m,n)))。
空间复杂度：O(1)，我们只需要恒定的内存来存储 9 个局部变量， 所以空间复杂度为 O(1)。
*/
public class sz1 {
    public static void main(String[] args) {
        int []a={1,2};
        int []b={3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }
    public static double findMedianSortedArrays(int[] A, int[] B){
        int m=A.length;
        int n=B.length;
        //首先确保n>=m，因为j=（m+n+1）/2-i  如果n<m 存在j为负数的情况
        if(n<m){
            int []temp=A;
            A=B;
            B=temp;
            //数组交换之后还要保证m<n
            int tmp=m;
            m=n;
            n=tmp;
        }
        //然后开始寻找合适的中间值 二分法
        int imin=0,imax=m;
        int half=(m+n+1)/2;
        while(imin<=imax){
            int i=(imin+imax)/2;
            int j=half-i;
            if(i<imax && B[j-1]>A[i]){
                imin=i+1;
            }else if(i>imin && A[i-1]>B[j]){
                imax=i-1;
            }else {
                int maxleft=0;
                if(i==0){
                    maxleft=B[j-1];
                }else if(j==0){
                    maxleft=A[i-1];
                }else{
                    maxleft=Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2==1){//如果是奇数
                    return maxleft;
                }

                int minright=0;
                if(i==m){
                    minright=B[j];
                }else if(j==n){
                    minright=A[i];
                }else{
                    minright=Math.min(A[i],B[j]);
                }
                    return (maxleft+minright)/2.0;
            }
        }
        return 0.0;
    }
}
