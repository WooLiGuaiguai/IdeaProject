package 数组和矩阵;
/*数组arr是[0, 1, ..., arr.length - 1]的一种排列，将这个数组分割成几个“块”，并将这些块分别进行内部排序。
之后再连接起来，使得连接的结果和按升序排序后的原数组相同，求最多的块数
*/
public class 分隔数组 {
    public static void main(String[] args) {
        int []arr1={4,3,2,1,0};//1
        int []arr2={1,0,2,3,4};//4
        System.out.println(maxChunksToSorted(arr1));
        System.out.println(maxChunksToSorted(arr2));
    }
    //如果分割后的数组中，最大数的下标与nums[i]所代表的值不相等，那么排序后，就无法形成从小到大的连贯的数组了
    //所以只有找到最大的数与下标当等时，用来计数的count才能加1，如果没有找到，那么子数组继续向后寻找，找到后重新查找新的子数组
    public static int maxChunksToSorted(int[] arr) {
        int count=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(max==i){
                count++;
            }
        }
        return count;
    }
}
