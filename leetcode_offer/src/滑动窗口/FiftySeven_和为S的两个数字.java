package 滑动窗口;

public class FiftySeven_和为S的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[2];
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (target < sum) r--;
            else if (target > sum) l++;
            else {
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            }
        }
        return new int[0];
    }
}
