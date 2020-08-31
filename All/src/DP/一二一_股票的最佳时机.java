package DP;

public class 一二一_股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices.length==0)return 0;
        int[]dp=new int[n+1];
        dp[1]=0;
        int minValue=Integer.MAX_VALUE;
        for(int i=2;i<=n;i++){
            minValue=Math.min(minValue,prices[i-2]);
            dp[i]=Math.max(dp[i-1],prices[i-1]-minValue);
        }
        return dp[prices.length];
    }
}
