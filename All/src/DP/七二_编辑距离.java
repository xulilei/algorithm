package DP;

public class 七二_编辑距离 {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
            //Dp[i][j]表示移动到word1的i，word2的j所需要的步数
        int[][]dp=new int[m+1][n+1];
        //第一行
        for(int i=1;i<=n;i++){
            dp[0][i]=dp[0][i-1]+1;
        }
        //第一列
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //硬记，与公共子序列一样，只是多了一个dp[i-1][j-1])
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
}
