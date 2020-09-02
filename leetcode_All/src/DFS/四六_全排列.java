package DFS;

import java.util.ArrayList;
import java.util.List;

public class 四六_全排列 {
    List<List<Integer>>res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        int[]visited=new int[nums.length];
        dfs(new ArrayList<>(),nums,visited);
        return res;
    }
    public void dfs(List<Integer>temp,int[]nums,int[]visited){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1)continue;
            //用个值记录当前坐标，下次遇到直接跳过
            visited[i]=1;
            temp.add(nums[i]);
            dfs(temp, nums, visited);
            visited[i]=0;
            temp.remove(temp.size()-1);
        }
    }
}
