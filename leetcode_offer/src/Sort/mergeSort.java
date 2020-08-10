package Sort;

import java.util.Arrays;

public class mergeSort {
    //归排的根本在于先分后合
    //先将数组拆分成最基本的单位，然后merge中排序
    //merge的几个关键参数，可以画图，从归并第二次开始
    //比如（4、3、2、6）->(3,4),(2,6): 3对应s1=left,4对应mid,2对应s2=mid+1,6对应right
    public static void main(String[] args) {
        int[]nums={3,5,1,3,2,6};
        mergeSort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(e-> System.out.println(e));

    }
    private static void mergeSort(int[] nums,int left,int right){
        if(left>=right)return;
        int mid=(left+right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums,left,mid,right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[]temp=new int[right-left+1];
        int index=0;
        int s1=left;
        int s2=mid+1;
        while (s1<=mid&&s2<=right){
            if(nums[s1]<nums[s2]){
                temp[index++]=nums[s1++];
            }else {
                temp[index++]=nums[s2++];
            }
        }
        while (s1<=mid){
            temp[index++]=nums[s1++];
        }
        while (s2<=right){
            temp[index++]=nums[s2++];
        }
        for(int j=0;j<temp.length;j++){
            nums[j+left]=temp[j];
        }
    }


}
