package Sort;

public class FiftyThree_在排序数组中查找数字出现次数 {
    public static void main(String[] args) {
        double[]nums={5,7.2,7.5,8,8,10};
        System.out.println(search(nums, 8));

    }

    static int search(double[] nums, int target) {
        //我这种接法double也可行
        //return getLargerThanTarget(nums,target)-getSmallerThanTarget(nums, target)-1;
        return getLargerThanTarget(nums,target)-getLargerThanTarget(nums, target-1);
    }
    //得到刚刚大于target值得位置
    private static int getLargerThanTarget(double[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid=(l+r)/2;
            if(nums[mid]<=target)l=mid+1;
            else r=mid-1;
        }
        return l;
    }
    //得到刚刚小于target值得位置
    private static int getSmallerThanTarget(double[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid=(l+r)/2;
            if(nums[mid]>=target)r=mid-1;
            else l=mid+1;
        }
        return r;
    }

}
