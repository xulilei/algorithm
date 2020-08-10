package Sort;

public class BinarySearch {
    public static void main(String[] args) {
        int[]nums={1,3,5,6,8};
        System.out.println(binarySearchDG(nums, 0, nums.length - 1, 5));
        System.out.println(binarySearchDD(nums, 0, nums.length - 1, 9));
    }
    // 已经要排好序
    //第一种递归
    public static boolean binarySearchDG(int[]nums,int left,int right,int target){
        if(left>right)return false;
        int mid=(left+right)/2;
        if(target>nums[mid])return binarySearchDG(nums, mid+1, right, target);
        else if(target<nums[mid])return binarySearchDG(nums, left, mid-1, target);
        else return true;
    }
    //第二种迭代
    public static boolean binarySearchDD(int[]nums,int left,int right,int target){
        int l=left,r=right;
        while (l<=r){
            int mid=(l+r)/2;
            if(target>nums[mid])l=mid+1;
            else if(target<nums[mid])r=mid-1;
            else return true;
        }
        return false;
    }
}
