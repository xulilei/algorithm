package 京东;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 二三五组成的第n小数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int index=sc.nextInt();
        System.out.println(minN(index));
    }
    public static int minN(int n){
        List<Integer>list=new ArrayList<>();
        dfs(list,1,2);
        dfs(list,1,3);
        dfs(list,1,5);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(i==n-1)return list.get(i);
        }
        return 0;
    }

    public static void dfs(List<Integer>list,int level,int num){
        if(level==6)return;
        list.add(num);
        dfs(list,level+1,num*10+2);
        dfs(list,level+1,num*10+3);
        dfs(list,level+1,num*10+5);
    }
}
