package DP;

public class FortySeven_礼物的最大值 {
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int row=grid.length;
        int column=grid[0].length;
        //dp[i][j]表示从grid[0][0]-->grid[i-1][j-1]的最大值
        int[][]dp=new int[row+1][column+1];
        //状态转移方程为dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][i-1];
        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[row][column];
    }
}
