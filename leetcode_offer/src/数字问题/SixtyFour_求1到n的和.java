package 数字问题;

public class SixtyFour_求1到n的和 {
    public int sumNums(int n) {
        int res=0;
        if(n==1) return 1;
        //写出递归语句
        //sumNums(n)=n+sumNums(n-1)
        res=n+sumNums(n-1);
        return res;
    }
    public int dpSumNums(int n){
        int[]dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+i;
        }
        return dp[n-1];
    }


}
