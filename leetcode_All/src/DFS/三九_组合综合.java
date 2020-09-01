package DFS;

import java.util.ArrayList;
import java.util.List;

public class 三九_组合综合 {
    List<List<Integer>>res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList<>();
        dfs(candidates,0,target,new ArrayList<>());
        return res;
    }
    public void dfs(int[] candidates,int index,int target,List<Integer>temp){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if (target < candidates[i])continue;
            temp.add(candidates[i]);
            dfs(candidates,i,target-=candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}
