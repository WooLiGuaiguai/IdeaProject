package 数组和矩阵;
/*Input: A = [5,4,0,3,1,6,2]   Output: 4
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
索引从0开始长度为N的数组A，包含0到N - 1的所有整数
找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
*/
public class 数组嵌套 {
    public static void main(String[] args) {
        int []nums={5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }
    public static int arrayNesting(int[] nums) {
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i;nums[j]!=-1;){
                int nextindex=nums[j];
                nums[j]=-1;//标记表示被访问过
                count++;
                j=nextindex;//更新下一个坐标
            }
            maxLen=Math.max(maxLen,count);
        }
        return maxLen;
    }
}
