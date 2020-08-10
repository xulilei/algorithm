package 数组问题;

import java.util.HashSet;
import java.util.Set;

public class FiftySix_数组中数字出现的次数 {
    public int singleNumber(int[] nums) {
        Set<Integer> setRes=new HashSet<>();
        Set<Integer>setTemp=new HashSet<>();

        for(int num:nums){
            if(!setTemp.contains(num)){
                setTemp.add(num);
                setRes.add(num);
            }else {
                if(setRes.contains(num)){
                    setRes.remove(num);
                }
            }
        }
        int res=0;
        for(int i:setRes){
            res=i;
        }
        return res;


    }
}
