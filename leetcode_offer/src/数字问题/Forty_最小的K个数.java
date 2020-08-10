package 数字问题;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Forty_最小的K个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer>queue=new PriorityQueue<>((v1,v2)->(v2-v1));
        if(arr.length==0||k==0)return new int[0];
        for(int num:arr){
            if(queue.size()<k){
                queue.add(num);
            }else if(queue.peek()>num){
                queue.poll();
                queue.add(num);
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
