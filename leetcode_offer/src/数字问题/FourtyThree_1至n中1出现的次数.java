package 数字问题;

public class FourtyThree_1至n中1出现的次数 {
    public int countDigitOne(int n) {
        //以当前位个数划分为高位，当前位，低位
        //明白三种情况
        //当前位等于0，则当前位出现1的个数位（高位*digit）
        //当前位等于1，则当前位出现1的个数位（高位*digit+low+1）
        //当前位大于1，则当前位出现1的个数位（高位+1）*digit
        int res=0,digit=1;
        int high=n/10;
        int low=0;
        int cur=n%10;
        while (high!=0||cur!=0){
            if(cur==0)res+=high*digit;
            else if(cur==1)res+=high*digit+low+1;
            else res+=(high+1)*digit;
           //从最左边的low开始所有值向高位进一位
            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }
        return res;



    }
}
