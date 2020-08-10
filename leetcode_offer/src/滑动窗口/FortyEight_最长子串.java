package 滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FortyEight_最长子串 {
    public int lengthOfLongestSubstring(String s) {
       Set<Character>set=new HashSet<>();
       if(s==null||s.length()==0)return 0;
       int left=0,right=0,res=0;
       while (right<s.length()){
           //缩小窗口
           while(set.contains(s.charAt(right))){
               set.remove(s.charAt(left));
               left++;
           }
           set.add(s.charAt(right));
           right++;
           res=Math.max(res,right-left);
       }
       return res;
    }
}
