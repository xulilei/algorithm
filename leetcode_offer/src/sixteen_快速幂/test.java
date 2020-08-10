package sixteen_快速幂;


public class test {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
    }
    public static long pow(long a,long b){
        long res=1;
        //转换成二进制
        while (b>0){
            if((b&1)==1){
                res=(res*a)%1000000007;
            }
            a=(a*a)%1000000007;
            b>>=1;
        }
        return  res;
    }

}



