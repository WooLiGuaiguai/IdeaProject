package 动态规划.股票交易;
//Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//Buying at prices[0] = 1
//Selling at prices[3] = 8
//Buying at prices[4] = 4
//Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//题目描述：
//  没有冷冻期，每交易一次都要支付一定的费用。
public class 需要交易费用的股票交易 {
    public static int maxProfit(int []prices,int fee){
        if (prices==null||prices.length==0){
            return 0;
        }
        int n=prices.length;
        int []sell=new int[n];
        int []hold=new int[n];
        sell[0]=0;//手里没有股票
        hold[0]=-prices[0];//手里有股票
        for (int i=1;i<n;i++){//因为是为了求手里的钱最多是多少
            //结束当天 手头没有股票的原因，没有买或者卖了
            sell[i]=Math.max(sell[i-1],hold[i-1]+prices[i]-fee);
            //结束当天 手头有股票，原因是没卖或者前一天卖了之后买了
            hold[i]=Math.max(hold[i-1],sell[i-1]-prices[i]);
        }
        return Math.max(sell[n-1],hold[n-1]);
    }

    public static void main(String[] args) {
        int []prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices,fee));
    }
}
