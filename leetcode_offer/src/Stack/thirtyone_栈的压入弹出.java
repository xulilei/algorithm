package Stack;

import java.util.Stack;

public class thirtyone_栈的压入弹出 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer>stack=new Stack<>();
            int i=0;
            for(int push:pushed){
                stack.push(push);
                //用stack的栈顶与弹出数组一次对比
                while(!stack.isEmpty()&&stack.peek()==popped[i]){
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
}
