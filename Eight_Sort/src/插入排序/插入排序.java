package 插入排序;

import java.util.Arrays;
/*
* 简单插入排序很循规蹈矩，不管数组分布是怎么样的，依然一步一步的对元素进行比较，移动，插入
* （1，4）3，5->(1,3,4) 5
* 保证前i-1位有序排列，将本次第i个插入前i-1个中某个位置
* 规则为，依次比较，大于i则将排好序的数索引向后移动一位，直到空出一个位置
* */
public class 插入排序 {
    public static void main(String[] args) {
        int[]arr=new int[]{4,3,2,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            int value=arr[i];
            int insertIndex=i;
            while (insertIndex>0&&arr[insertIndex-1]>value){
                //向后移动一个，腾出要插入的空地
                arr[insertIndex]=arr[insertIndex-1];
                insertIndex--;
            }
            arr[insertIndex]=value;
        }
    }
}
