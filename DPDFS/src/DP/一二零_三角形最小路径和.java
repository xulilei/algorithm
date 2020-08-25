package DP;

import java.util.List;

public class 一二零_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        //dp[i][j]表示到第i行，第j列的和最小
        int[][]dp=new int[n][n];
        //初始值
        dp[0][0]=triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            //最左边，只能由上层的最左边过来
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            for(int j=1;j<i;j++){
                //状态转移方程为上一层的相邻两数的最小值加上本层的该节点
                dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
            }
            //最右边，只能由上层最右边过来
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        int res=dp[n-1][0];
        for(int i=0;i<n;i++){
            res=Math.min(res,dp[n-1][i]);
        }
        return res;
    }
}
