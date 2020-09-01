package DP;

public class 一二二_股票最佳时机二 {
    //DP解法,增加一个状态，
    public int maxProfit(int[] prices) {
        int[][]dp=new int[prices.length+1][2];
        dp[1][0]=0;
        dp[1][1]=-prices[0];
        for(int i=2;i<=prices.length;i++){
            //dp[i][0]表示第i天售出能获得的最大利润，即前一天的状态保持不变，和前一天买入状态+售出股票中的最大值
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            //dp[i][1]表示第i天买入能获得的最大利润，即前一天的状态保持不变，和前一天售出状态+买入股票中的最大值
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
        }
        return dp[prices.length][0];

    }
    //贪心算法
    //即认为每天都有买卖，利润大于0就加上，小于或等于0就丢弃，这样就不会亏
    public int maxProfitTanXin(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=(prices[i]-prices[i-1]);
            }
        }
        return profit;
    }

}
