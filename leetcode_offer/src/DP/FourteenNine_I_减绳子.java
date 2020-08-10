package DP;

public class FourteenNine_I_减绳子 {
    public int cuttingRope(int n) {
        if(n==2)return 1;
        if(n==3)return 2;
        int[]dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            for(int j=1;j<4;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}
