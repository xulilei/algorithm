package DP;

public class FortyNine_丑数 {

    public  int nthUglyNumber(int n) {
       //所有丑数了不得都是由丑数中的其他数*2 *3 *5来的
        //记录索引，乘过了就将索引加1
        int a=1,b=1,c=1;
        int[]dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            //记录本轮由上一轮产生的下一轮丑数
            int n2=dp[a]*2,n3=dp[b]*3,n5=dp[c]*5;
            //从小到大排列，因此取最小的成为本轮的丑数
            dp[i]=Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2)a++;
            if(dp[i]==n3)b++;
            if(dp[i]==n5)c++;
        }
        return dp[n];

    }
}
