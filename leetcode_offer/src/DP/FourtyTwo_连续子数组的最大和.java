package DP;

public class FourtyTwo_连续子数组的最大和 {
    //dp[i]表示，以i结尾前的子数组的最大值
    //状态方程为当dp[i-1]>0，说明前面子数组会对后面的产生正影响，反之是负影响
    //因此分析出当dp[i-1]>0时，dp[i]=dp[i-1]+nums[i];当dp[i-1]<0，dp[i]=nums[i];
    //初始条件为dp[0]=nums[0]；
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<=0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

}
