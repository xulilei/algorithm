package 数字问题;

public class ThirtyNine_数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int res=0,votes=0;
        for(int num:nums){
            if(votes==0)res=num;
            if(res==num)votes++;
            else votes--;
        }
        return res;
    }
}
