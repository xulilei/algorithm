package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四六_全排列II {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new ArrayList<>();
        int[]visited=new int[nums.length];
        Arrays.sort(nums);
        dfs(new ArrayList<>(),nums,visited);
        return res;

    }
    public void dfs(List<Integer>temp,int[]nums,int[]visited){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1)continue;
            //并且前一个已经被遍历了
            if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==1)continue;
            visited[i]=1;
            temp.add(nums[i]);
            dfs(temp, nums, visited);
            visited[i]=0;
            temp.remove(temp.size()-1);
        }
    }
}
