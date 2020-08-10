package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

public class FiftyNine_I_滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0)return new int[0];
        int[]res=new int[nums.length-k+1];
        Deque<Integer>queue=new LinkedList<>();
        //处理未形成滑动窗口
        for(int i=0;i<k;i++){
            while (!queue.isEmpty()&&queue.peekLast()<nums[i])queue.removeLast();
            queue.addLast(nums[i]);
        }
        res[0]=queue.peekFirst();
        for(int i=k;i<nums.length;i++){
            if(queue.peekFirst()==nums[i-k])queue.removeFirst();
            while (!queue.isEmpty()&&queue.peekLast()<nums[i])queue.removeLast();
            queue.addLast(nums[i]);
            res[i-k+1]=queue.peekFirst();
        }
        return res;

    }
}
