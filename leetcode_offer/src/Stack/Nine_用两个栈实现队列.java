package Stack;

import java.util.Stack;

public class Nine_用两个栈实现队列 {
    //栈先入后出
    //队列先入先出
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public Nine_用两个栈实现队列() {
        stackIn=new Stack<>();
        stackOut=new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        int res=0;
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        if(stackOut.isEmpty()){
            return  -1;
        }
        res=stackOut.pop();
        return res;
    }
}
