package 希尔排序;

import java.util.Arrays;

/*
* 希尔排序是对直接插入排序的一种优化
* 是按照跳跃式分组的方式，按组进行插入排序，之后每次将增量减为1/2，直到增量为0
* */
public class 希尔排序 {
    public static void main(String[] args) {
        int[]arr=new int[]{4,3,2,1,8,6,9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[]arr){
        for(int step=arr.length/2;step>0;step/=2){
            for(int i=step;i<arr.length;i++){
                int value=arr[i];
                int insertIndex=i;
                while (insertIndex-step>=0&&arr[insertIndex-step]>value){
                    arr[insertIndex]=arr[insertIndex-step];
                    insertIndex-=step;
                }
                arr[insertIndex]=value;
            }
        }
    }
}

