package 数字问题;

public class twentyOne_调整数组顺序使奇数在前 {
    public int[] exchange(int[] nums) {
        int left=0,right=nums.length-1,temp=0;
        while (left<right){
            while (left<right&&nums[left]%2!=0)left++;
            while (left<right&&nums[right]%2!=1)right--;
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        return nums;
    }
}
