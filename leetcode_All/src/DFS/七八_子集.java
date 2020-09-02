package DFS;

import java.util.ArrayList;
import java.util.List;

public class 七八_子集 {
    List<List<Integer>>res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        dfs(new ArrayList<>(),nums,0);
        return res;
    }
    public void dfs(List<Integer>temp,int[]nums,int index){
        if(index>nums.length)return;
        res.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
