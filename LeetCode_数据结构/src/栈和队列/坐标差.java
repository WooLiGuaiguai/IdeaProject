package 栈和队列;

import java.util.Arrays;
import java.util.Stack;

public class 坐标差 {
    public static void main(String[] args) {
        int [] T={73, 74, 75, 71, 69, 72, 76, 73};
        int []daliy=dailyTemperatures(T);
        for(int i=0;i<daliy.length;i++){
            System.out.print(daliy[i]+" ");
        }
        System.out.println();

        int []nums={1,2,1};
        int []next=nextGreaterElements(nums);
        for(int i=0;i<next.length;i++){
            System.out.print(next[i]+" ");
        }
    }
    //给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
    //数字 x 的下一个更大的元素是按数组遍历之后的第一个比它更大的数，这意味着应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
    public static int[] nextGreaterElements(int[] nums) {
        int []next=new int[nums.length];
        Stack<Integer>stack=new Stack<>();
        Arrays.fill(next,-1);//初始化
        for(int i=0;i<nums.length*2;i++){
            int num=nums[i%nums.length];
            while(!stack.isEmpty()&&num>nums[stack.peek()]){
                next[stack.pop()]=num;
            }
            if(i<nums.length){
                stack.push(i);//节约时间
            }
        }
        return next;
    }
    //根据每日气温列表重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用0来代替。
    //例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    public static int[] dailyTemperatures(int[] T) {
        int[] daliy=new int[T.length];//返回需要的数据
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int preindex=stack.pop();
                daliy[preindex]=i-preindex;
            }
            stack.add(i);
        }
        return daliy;
    }
}
