package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三九_组合总和II {
    List<List<Integer>>res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        if(candidates.length==0)return res;
        Arrays.sort(candidates);
        dfs(candidates,new ArrayList<>(),0,target);
        return res;
    }
    public void dfs(int[] candidates,List<Integer>temp,int index, int target){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target>0){
            for(int i=index;i<candidates.length;i++){
                if (target < candidates[i])
                    continue;
                if(i>index&&candidates[i]==candidates[i-1])continue;
                temp.add(candidates[i]);
                //多少次了 自己没B数吗index要变成i的啊
                dfs(candidates, temp, i+1, target-candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
