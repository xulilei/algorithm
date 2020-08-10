package 数字问题;

import java.util.PriorityQueue;
import java.util.Queue;

public class FortyOne_数据流的中位数 {
    Queue<Integer>big,small;

    public FortyOne_数据流的中位数() {
        big=new PriorityQueue<>((e1,e2)->(e1-e2));
        small=new PriorityQueue<>((e1,e2)->(e2-e1));
    }

    public void addNum(int num) {
        if(big.size()==small.size()){
            small.add(num);
            big.add(small.poll());
        }else {
            big.add(num);
            small.add(big.poll());
        }
    }

    public double findMedian() {
        return small.size()==big.size()?(small.peek()+big.peek())/2.0:big.peek();

    }
}
