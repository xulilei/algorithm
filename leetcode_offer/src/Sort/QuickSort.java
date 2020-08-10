package Sort;

import java.util.Arrays;

public class QuickSort {
    //快排的根本在于
    //将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。
    //此时，左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值
    public static void main(String[] args) {
        int[]arr={1,3,5,7,2,8};
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(e-> System.out.println(e));
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left>right)return;
        //设定一个基准值
        int base=arr[left];
        int i=left;
        int j=right;
        while (i<j){
            //这两个while是按照自己定义的规则
            while (arr[j]>base&&i<j)j--;
            while (arr[i]<=base&&i<j)i++;
            //交换从左边开始比基准值大的和从右边开始比基准值小的
            //当两个相遇退出时候，这里的交换就是和本身交换
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
        arr[left]=arr[i];
        arr[i]=base;
        //这样一来，基准值在数组中的位置就找到了
        //以基准值为线，递归执行
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);

    }
}
