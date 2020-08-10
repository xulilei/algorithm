package Stack;

import java.util.Stack;

public class Thirty_包含main的栈 {
    //要求实现获得栈的最小元素的 min
    Stack<Integer>A,B;
    public Thirty_包含main的栈() {
        A=new Stack<>();
        B=new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.isEmpty()||B.peek()>=x)B.add(x);

    }

    public void pop() {
        A.pop();
        if(A.pop()==B.peek())B.pop();
    }

    public int top() {
        return A.peek();

    }

    public int min() {
        return B.peek();
    }
}
