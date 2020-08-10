package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FiftyNine_队列的最大值 {

        //辅助队列
        Deque<Integer> deque;
        //主队列，按从大到小规则
        Queue<Integer> queue;


        public FiftyNine_队列的最大值() {
            deque=new LinkedList<>();
            queue=new LinkedList<>();
        }

        public int max_value() {
            return deque.size()>0?deque.peekFirst():-1;
        }
        //队列的入队
        public void push_back(int value) {
            queue.offer(value);
            //维护了deque的大小顺序
            while(deque.size()>0&&deque.peekLast()<value){
                deque.pollLast();
            }
            deque.offerLast(value);
        }
        //队列的出队
        public int pop_front() {
            int temp=queue.size()>0?queue.poll():-1;
            //deque的最大值由于 主队列中已经移除了 因此没有意义需要T出
            if(deque.size()>0&&deque.peekFirst().equals(temp)){
                deque.poll();
            }
            //这个temp是主队列队首的值
            return temp;

        }

}
