package 动态规划.股票交易;

public class 需要冷却期的股票交易 {

    public static int maxProfit(int[] prices){
        if(prices==null||prices.length==0)
            return 0;
        int n=prices.length;
        int []sell=new int[n];//结束当天手里没有股票时已经获得的最大利润
        int []hold=new int[n];//结束当天手里有股票时已经获得的最大利润
        sell[0]=0;
        hold[0]=-prices[0];
        for (int i=1;i<n;i++){
            //当天结束手里没有股票  意味着没有买（等于sell[i-1]）或者卖掉了（hold[i-1]+prices[i]）
            sell[i]=Math.max(sell[i-1],hold[i-1]+prices[i]);
            //手里有股票 意味着 今天刚买（sell[i-2]-prices[i]）或者没有卖（等于hold[i-1]）
            hold[i]=Math.max((i>=2)?sell[i-2]-prices[i]:-prices[i],hold[i-1]);
        }
        return Math.max(sell[n-1],hold[n-1]);
    }

    public static void main(String[] args) {
        int []a={1,2,3,0,2};
        System.out.println(maxProfit(a));
    }
}
