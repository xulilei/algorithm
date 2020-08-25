package DP;

public class 五三_最大子序和 {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)return 0;
        //定义状态dp[i]表示以i结束最大子序和
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
