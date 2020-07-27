package 动态规划.股票交易;
//输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3
public class 只能进行k次的股票交易 {
    //局部最优和全局最优
    //维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global [i] [j]），
    //另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local [i] [j]）
    //全局：global [i] [j]=max(local [i] [j],global [i-1] [j])，
    //取当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）
    //局部：local [i] [j]=max(global [i-1] [j-1]+max(diff,0),local [i-1] [j]+diff)
    //第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，赚钱加diff，否则+0
    //第二个量则是取local第i-1天j次交易，然后加上今天的差值
    //这里因为local [i-1] [j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，
    //而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local [i] [j]必须在最后一天卖出的条件了）
    public static  int maxProfit2(int []prices,int k){
        if(prices==null||prices.length==0)
            return 0;
        int []local=new int [k+1];
        int []global=new int [k+1];
        for(int i=0;i<prices.length-1;i++){
            int diff=prices[i+1]-prices[i];
            for(int j=k;j>=1;j--){
                local[j]=Math.max(global[j-1]+(diff>0?diff:0),local[j]+diff);
                global[j]=Math.max(local[j],global[j]);
            }
        }
        return global[k];
    }
    public static void main(String[] args) {
        int []a={3,2,6,5,0,3} ;
        int []b={1,2,3,4,5};
        System.out.println(maxProfit2(a,2));
        System.out.println(maxProfit2(b,2));
    }
}
