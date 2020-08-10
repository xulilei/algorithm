package 滑动窗口;

import java.util.*;

public class 最短超串 {
    public static void main(String[] args) {
        int[] big={7,5,9,0,2,1};
        int[] small={1,5,9};
        Arrays.stream(shortestSeq(big, small)).forEach(e-> System.out.println(e));
    }
    public static int[] shortestSeq(int[] big, int[] small) {
        //定义状态 left right为窗口，start为最短子串满足match=3的开始，这个滑动窗口是一个左闭右开的
        int left=0,right=0,start=0,min=Integer.MAX_VALUE,match=0;
        //保存子串的值，值统一为1
        Map<Integer,Integer>needs=new HashMap<>();
        for(int s:small)needs.put(s,1);
        //保存子串的值出现的次数
        Map<Integer,Integer>window=new HashMap<>();
        //规定右边界超出后退出循环
        while (right<big.length){
            //右边界值
            Integer c1=big[right];
            if(needs.containsKey(c1)){
                window.put(c1,window.getOrDefault(c1,0)+1);
                //保证match最大为3，即子串的值在窗口中都存在
                if(needs.get(c1)==window.get(c1)){
                    match++;
                }
            }
            right++;
            //左窗口缩进
            while (match==needs.size()){
                //先更新一下窗口，左闭右开
                if(right-left<min){
                    start=left;
                    min=right-left;
                }
                Integer c2=big[left];
                if(needs.containsKey(c2)){
                    //左窗口缩进的时候，划过needs中的值就将其减1
                    window.put(c2,window.getOrDefault(c2,0)-1);
                    //当窗口中的子串小于1，即没有的时候，将match-1
                    if(window.get(c2)<needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
        return min==Integer.MAX_VALUE?new int[0]:new int[]{start,start+min-1};
    }
}
