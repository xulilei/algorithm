package 奇安信;

public class 爬楼梯 {
    public static void main(String[] args) {
        int[]person=new int[]{3,2,4};
        System.out.println(house(person));
    }
      public static int house(int[] person){
          int n=person.length;
          int res=0;
          if(n==0)return 0;
          int[]dp=new int[n];
          dp[0]=1;
          for(int i=0;i<n-1;i++){
             if(person[i]<person[i+1])dp[i+1]=dp[i]+1;
             else if(person[i]>=person[i+1])dp[i+1]=1;
          }
          for(int i=0;i<n;i++){
              res+=dp[i];
          }
          return res;
      }
}
