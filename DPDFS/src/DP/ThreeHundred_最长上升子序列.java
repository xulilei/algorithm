package DP;

import java.util.Arrays;

public class ThreeHundred_最长上升子序列 {
    //状态定义dp[i]=以i结尾的最长上升子序列长度
    //状态转移方程为dp[i]=Math.max(dp[i],dp[j]+1(if(nums[i]>nums[j])
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0; 
        int[]dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;

    }
}
