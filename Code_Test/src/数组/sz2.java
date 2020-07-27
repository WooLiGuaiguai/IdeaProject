package 数组;
/*数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。*/
public class sz2 {
    public static void main(String[] args) {
        int []number={1,2,3,5,6,9,10,15,19};
        int []n={ };
        int []a=twoSum(number,15);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
    public static int[] twoSum(int[] numbers, int target){
        if (numbers.length==0){
            return null;
        }
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i,j};
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}
