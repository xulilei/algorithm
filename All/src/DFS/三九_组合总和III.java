package DFS;

import java.util.ArrayList;
import java.util.List;

public class 三九_组合总和III {
    List<List<Integer>>res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res=new ArrayList<>();
        dfs(new ArrayList<>(),k,n,1);
        return res;
    }
    public void dfs(List<Integer>temp,int k,int n,int index){
        if(k==0&&n==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(k>0&&n>0){
            for(int i=index;i<=9;i++){
                temp.add(i);
                dfs(temp, k-1, n-i, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
