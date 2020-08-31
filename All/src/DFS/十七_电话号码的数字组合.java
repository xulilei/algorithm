package DFS;

import java.util.ArrayList;
import java.util.List;

public class 十七_电话号码的数字组合 {
    private String letterMap[]={" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String>res;
    public List<String> letterCombinations(String digits) {
        res=new ArrayList<>();
        if(digits.equals(""))return res;
        dfs(digits,0,"");
        return res;
    }
    public void dfs(String digits,int index,String s){
        //
        if(index==digits.length()){
            res.add(s);
        }
        char c=digits.charAt(index);
        String temp=letterMap[c-'0'];
        for(int i=0;i<temp.length();i++){
            dfs(digits,index+1,s+temp.charAt(i));
        }
    }
}
