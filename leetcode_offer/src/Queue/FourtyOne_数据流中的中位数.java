package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class FourtyOne_数据流中的中位数 {
    Queue<Integer> small,big;

    /** initialize your data structure here. */
    public FourtyOne_数据流中的中位数() {
        //小顶堆放大的元素，使得peek出来的是最大中最小的
        small=new PriorityQueue<>();
        //同理
        big=new PriorityQueue<>((x,y)->(y-x));
    }

    public void addNum(int num) {

        if(small.size()==big.size()){
            small.add(num);
            big.add(small.poll());
        }else{
            big.add(num);
            small.add(big.poll());
        }
    }
    public double findMedian() {
        return small.size()==big.size()?(small.peek()+big.peek())/2.0:big.peek();

    }
}
