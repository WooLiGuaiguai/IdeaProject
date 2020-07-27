package 数组;
/*Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
public class sz6 {
    public static void main(String[] args) {
        int []a={1,3,5,7,0,0,0};
        int []b={2,4,6};
        merge(a,4,b,3);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int index1=m-1,index2=n-1;//两个下标指针
        int index=m+n-1;//最后数组的下标指针
        while(index1>=0||index2>=0){
            if(index1<0){
                nums1[index--]=nums2[index2--];
            }else if(index2<0){
                nums1[index--]=nums1[index1--];
            }else {
                nums1[index--]=(nums1[index1]>nums2[index2])?nums1[index1--]:nums2[index2--];
            }
        }
    }
}
