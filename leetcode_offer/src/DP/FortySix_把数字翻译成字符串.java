package DP;

public class FortySix_把数字翻译成字符串 {
        public int translateNum(int num) {
            //转移方程 当最后两位小于25或者大于10，说明可以组成一个字母dp[i]=dp[i-1]+dp[i-2]
            //否则 dp[i]=dp[i-1]
            String str=String.valueOf(num);
            //为什么长度要n+1
            //思考一个问题
            //dp[0]表示没有数字，dp[1]表示一个数字.dp[2]表示2位数字，25两位数字长度为2，因此要将长度+1,才可以表示
            //即判断dp[0]能不能代表第一个数字的情况

            int[]dp=new int[str.length()+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2;i<=str.length();i++){
               String temp= str.substring(i-2,i);
               if(temp.compareTo("10")>=0&&temp.compareTo("25")<=0){
                   dp[i]=dp[i-1]+dp[i-2];
               }else dp[i]=dp[i-1];
            }
            return dp[str.length()];
        }

}
