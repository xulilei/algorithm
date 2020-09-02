package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 七八_子集II {
    List<List<Integer>>res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(new ArrayList<>(),nums,0);
        return res;

    }
    public void dfs(List<Integer>temp,int[]nums,int index){
        if(index>nums.length)return;
        res.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            dfs(temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
