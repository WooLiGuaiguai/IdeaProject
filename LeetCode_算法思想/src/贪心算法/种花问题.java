package 贪心算法;
//给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 
// 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
//示例 1:
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
//示例 2:
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
public class 种花问题 {
    public static void main(String[] args) {
        int []flowerbed={1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed,1));
        System.out.println(canPlaceFlowers(flowerbed,2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        //首先考虑数组长度小于n的时候
        if (flowerbed.length<n){
            return false;
        }
        int count=0;
        for (int i=0;i<flowerbed.length;i++){
            if((flowerbed[i]==0) && (i==0||flowerbed[i-1]==0) && (i==flowerbed.length-1||flowerbed[i+1]==0)) {
                flowerbed[i] = 1;
                count ++;
            }
        }
        return count>=n;
    }
}
