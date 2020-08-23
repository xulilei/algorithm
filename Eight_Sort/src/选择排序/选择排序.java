package 选择排序;

import java.util.Arrays;

/*
* 不断的把最小值往前扔
* */
public class 选择排序 {
    public static void main(String[] args) {
        int[]arr=new int[]{4,3,2,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
