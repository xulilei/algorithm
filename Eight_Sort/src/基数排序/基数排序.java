package 基数排序;

import java.util.Arrays;
/*
* 基数排序的基本思想是，通过从个位开始讲每个书按照该位所在的值依次放入所在的桶
* 再重新覆盖原数组后，位数向高位进一位
* 当最高位执行完毕，这个数组就是一个有序数组
* */
public class 基数排序 {
    public static void main(String[] args) {
        int[]arr=new int[]{4,3,2,1,8,6,9,13,312,654,7865,853,535,35,10000};
        jiShuSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void jiShuSort(int[]arr){
        //找到数最大的位数
        int max=arr[0];
        for(int a:arr){
            if(a>max)max=a;
        }
        //代表位数
        int weiShu=(max+"").length();
        //从个位开始
        int n=1;
        //每一行的位数值相等，0-9总共十个数，创建十行，每行长度最大为arr的长度
        int[][] bucket=new int[10][arr.length];
        //存放的是每个位数容纳的数的个数，比如order[1]，表示个位为1的数的个数，初始值都为0
        int[]order=new int[10];
        //将数组从bucket中拿出来覆盖原数组用到的索引
        int index=0;
        //从各位开始一直到最高位
        while (n<=Math.pow(10,weiShu)){
            //将数组中的每个数，按照本轮的位数，放入所在的行
            for(int a:arr){
                int digit=(a/n)%10;
                bucket[digit][order[digit]]=a;
                order[digit]++;
            }
            //将bucket中的数据取出覆盖原数组
            for(int i=0;i<10;i++){
                //当本位数存储的数不为空时
                if(order[i]!=0){
                    for(int j=0;j<order[i];j++){
                        arr[index++]=bucket[i][j];
                    }
                }
                //重置计数器
                order[i]=0;
            }
            //位数加1
            n*=10;
            //覆盖索引归零
            index=0;
        }
    }

}
