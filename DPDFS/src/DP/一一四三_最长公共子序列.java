package DP;

public class 一一四三_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        //状态定义dp[i][j]表示str1的0-i与str2中0-j中最长公共子序列的长度
        int l1=text1.length(),l2=text2.length();
        int[][]dp=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //如果相等，则最长子序列在各自前一个状态+1；
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    //如果不等，从二者去头中选择最大的一个
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
