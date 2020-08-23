package 归并排序;
/*
* 先分（mergeSort）再合（merge）
* 先分以mid为中线
* merge时写一个例子方便理解
*  left（l）        mid     mid+1（r）          right
* （1，    ,5        4）   （2，        ,6           3）
* 临时数组int[]temp=new int[right-left+1];
* */

public class mergeSort {
    public static void mergeSort(int[]arr,int left,int right){
        if(left>=right)return;
        int mid=(left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);

    }
    public static void merge(int[]arr,int left,int mid,int right){
        int l=left,r=mid+1;
        int[]temp=new int[right-left+1];
        int index=0;
        while (l<=mid&&r<=right){
            if(arr[l]<arr[r]){
                temp[index++]=arr[l++];
            }else {
                temp[index++]=arr[r++];
            }
        }
        while (l<=mid){
            temp[index++]=arr[l++];
        }
        while (r<=right){
            temp[index++]=arr[r++];
        }
        for(int i=0;i<temp.length;i++){
            arr[left+i]=temp[i];
        }
    }

}
