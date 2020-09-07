package 数组;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
//在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

public class 装最多的水_双指针 {
    public static int maxArea(int[] height){
        int l=0,r=height.length-1;
        int max=0;
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            max=Math.max(max,area);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []num={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(num));

    }
}
