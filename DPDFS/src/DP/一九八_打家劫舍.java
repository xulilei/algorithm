package DP;

public class 一九八_打家劫舍 {
    //状态转移方程dp[n]=Math.max(dp[n-1],dp[n-2]+num)
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        //定义状态,dp[i]定义为到第i家时，最大金额
        int[]dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        int res=0;
        for(int i=2;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length];
    }

}
