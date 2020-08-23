package 冒泡排序;

import java.util.Arrays;
/*
* 从第一个数开始，将最大数不断向后移
* */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[]arr=new int[]{4,3,2,1};
        maoPao(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void maoPao(int[]arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
