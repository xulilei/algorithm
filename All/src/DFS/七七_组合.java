package DFS;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class 七七_组合 {
    List<List<Integer>>res;
    public List<List<Integer>> combine(int n, int k) {
        res=new ArrayList<>();
        dfs(1,new ArrayList<>(),n,k);
        return res;
    }
    public void dfs(int start,List<Integer>temp,int n,int k){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
        }else {
            for(int i=start;i<=n;i++){
                temp.add(i);
                dfs(i+1,temp,n,k);
                temp.remove(temp.size()-1);
            }
        }

    }
}
