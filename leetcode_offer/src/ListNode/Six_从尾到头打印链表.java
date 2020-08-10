package ListNode;


import java.util.Stack;

public class Six_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer>stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.add(cur.val);
            cur=cur.next;
        }
        int[]res=new int[stack.size()];
        for(int i=0;i<res.length;i++){
            res[i]=stack.pop();
        }
        return res;

    }
}
