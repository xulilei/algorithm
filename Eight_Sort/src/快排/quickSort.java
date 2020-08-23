package 快排;

import java.util.Arrays;

/*
* 选取一个base，一般以left为准，不断将base放到左侧小于他右侧大于他的位置
* */
public class quickSort {
    public static void main(String[] args) {
        int[]arr=new int[]{4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[]arr,int left,int right){
        if(left>right)return;
        int base=arr[left];
        //索引
        int l=left;
        int r=right;
        while (l<r){
            while (arr[r]>base&&l<r)r--;
            while (arr[l]<=base&&l<r)l++;
            int temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
        }
        arr[left]=arr[l];
        arr[l]=base;
        quickSort(arr, left, l-1);
        quickSort(arr, l+1, right);

    }
}
