package DP;

import java.util.Arrays;

public class 二一三_打家劫舍二 {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        else if(nums.length==1)return nums[0];
        //分析为要么打劫第一家但不打劫最后一家，或者不打劫第一家，但是打劫最后一家
        else return Math.max(robImpl(Arrays.copyOfRange(nums,0,nums.length-1)),
                    robImpl(Arrays.copyOfRange(nums,1,nums.length)));

    }
    //198打家劫舍基本解法
    public int robImpl(int[] nums) {
        if(nums.length==0)return 0;
        //dp[i]表示打劫到第i间房子所获得的最大金额
        int[]dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];

    }
}
