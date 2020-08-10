package DP;

public class SixtyThree_股票最大利润 {
    public static void main(String[] args) {
        int[]prices={1,2};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        //第i天时候的，最大利润的状态方程为前i-1天的最大利润，和今天的价格减去之前最小的价格
        //dp[i]=Max(dp[i-1],price-lowPrice)
        if(prices.length==0)return 0;
        int lowPrice=Integer.MAX_VALUE;
        int[] dp=new int[prices.length+1];
        //从第二天开始
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=prices.length;i++){
            //之前最小的价格
            lowPrice=Math.min(lowPrice,prices[i-2]);
            dp[i]=Math.max(dp[i-1],prices[i-1]-lowPrice);
        }
        return dp[prices.length];
    }
}
