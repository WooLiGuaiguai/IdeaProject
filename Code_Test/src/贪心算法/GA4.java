package 贪心算法;

public class GA4 {
    public static void main(String[] args) {
        int []p={7,1,5,3,6,4};
        int []q={7,6,4,3,1};
        int []a={7,1,5,3,6,4};
        int []b={7,6,4,3,1};
        System.out.println(maxProfit(p));
        System.out.println(maxProfit(q));
        System.out.println(maxProfit2(a));
        System.out.println(maxProfit2(b));
    }
    public static int maxProfit2(int [] prices){
        int total=0;//保存最终利润
        int input=prices[0];//初始 进价
        for(int i=1;i<prices.length;i++){
            if(input<=prices[i]){
                total=total+prices[i]-input;
            }
            input=prices[i];
        }
        return total;
    }
    public static int maxProfit(int[] prices){
        int n = prices.length;
        if (n == 0) return 0;
        //首先分析 前面便宜后面贵才可以卖出
        int input=prices[0];
        int max=0;//保存价格差值
        for(int j=1;j<prices.length;j++){
            //如果后面的价格比当前进价低，那么进价肯定要取得后面这个
            if(input>prices[j]){
                input=prices[j];
            }
            else{
            //如果后面的价格比进价高 说明可卖，将差值保存
                max=Math.max(max,prices[j]-input);
            }
        }
        return max;
    }
}
