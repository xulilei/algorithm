package Sort;

public class FiftyThree_0到n减1缺失的数字 {
    public static void main(String[] args) {
        int[]nums={0};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>mid)r=mid-1;
            else l=mid+1;
        }
        return l;
    }
}
