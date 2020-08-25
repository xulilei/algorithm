package DP;

public class Five_回文子串 {
    //dp
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2)return s;
        //dp[i][j]表示s[i....j]是否为回文子串
        boolean[][]dp=new boolean[len][len];
        char[]chars=s.toCharArray();
        int maxLen=1,begin=0;
        //单个字符肯定是回文串
        for(int i=0;i<len;i++)dp[i][i]=true;
        //表格填表
        //转移方程dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                //两头不等必然不是
                if(chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                    //两头等，并且j-i<3则必然是回文
                    if(j-i<3)dp[i][j]=true;
                    //如果去掉头尾是回文，那么此时也是回文
                    else dp[i][j]=dp[i+1][j-1];
                }
                //记录最大回文子串的开始
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

}
