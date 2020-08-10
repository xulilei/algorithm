package Sort;

public class FiftyOne_数组中的逆序对 {
    int res;
    public int reversePairs(int[] nums) {
        if(nums.length<2)return 0;
        res=0;
        mergeSort(nums,0,nums.length-1);

        return res;

    }
    private void mergeSort(int[]nums,int left,int right){
        if(left>=right)return;
        int mid=(left+right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[]temp=new int[right-left+1];
        int index=0;
        int s1=left,s2=mid+1;
        while (s1<=mid&&s2<=right){
            if(nums[s1]<=nums[s2]){
                temp[index++]=nums[s1++];
            }else {
                temp[index++]=nums[s2++];
                // 本题核心：由于 nums[pos1] > nums[pos2]，
                // 则从 nums[pos1] 到 nums[middle] 必定都是大于 nums[pos2] 的，
                // 因为两部分的子数组已经是各自有序的
                res+=(mid-s1+1);
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
