package 数字问题;

public class FortyFour_数字序列中的某一位数字 {

    public int findNthDigit(int n) {
        int digit=1;
        long start=1;
        long count=9;
        while (n>count){
            n-=count;
            digit+=1;
            start*=10;
            count=digit*start*9;
        }
        //处理剩下的部分，从start开始,n-1是因为从0开始的
        long num=start+(n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}
