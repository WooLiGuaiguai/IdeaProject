package 贪心算法;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int []prices={7,1,5,3,6,4};
        int []prices2={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices2));
    }
    //设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    public static int maxProfit2(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int total=0;
        int input=prices[0];
        for(int i=1;i<prices.length;i++){
            if (input>prices[i]){
                input=prices[i];
            }else{
                total=total+prices[i]-input;
                input=prices[i];
            }
        }
        return total;
    }
    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    //示例 1:
    //输入: [7,1,5,3,6,4]
    //输出: 5
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
    public static int maxProfit(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int max=0;
        int input=prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]<input){
                input=prices[i];
            }else{
                max=Math.max(max,prices[i]-input);
            }
        }
        return max;
    }
}
