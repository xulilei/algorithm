package DP;

public class 一五二_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if(nums.length==0)return 0;
        int[][]dp=new int[nums.length][2];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        int res=dp[0][1];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=0){
                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][0]);
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][1]);
            }else {
                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][1]);
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][0]);
            }
            res=Math.max(res,dp[i][1]);
        }
        return res;
    }
}
