package 数组问题;

import java.util.HashSet;
import java.util.Set;

public class Three_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int res=0;
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                res=num;
                break;
            }
        }
        return res;

    }
}
