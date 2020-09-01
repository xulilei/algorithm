package DFS;

import java.io.BufferedReader;
import java.util.*;

public class JD_由二三五组成一千个数 {
    public static void main(String[] args) {

        System.out.println(listN(3));

    }
    public static int listN(int n){
        List<String>list=new ArrayList<>();
        dfs(list,1,"2");
        dfs(list,1,"3");
        dfs(list,1,"5");
        Collections.sort(list, Comparator.comparingInt(Integer::parseInt));
        System.out.println(list.toString());
        int size=list.size();
        int res;
        if(n-1<size){
            res=Integer.parseInt(list.get(n-1));
            return res;
        }
        return 0;
    }

    public static void dfs(List<String>list,int times,String num){
        if(times==7)return;
        list.add(num);
        dfs(list,times+1, num + "2");
        dfs(list,times+1, num + "3");
        dfs(list,times+1, num + "5");
    }
}
