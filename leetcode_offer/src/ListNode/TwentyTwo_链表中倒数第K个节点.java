package ListNode;

public class TwentyTwo_链表中倒数第K个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre=head,cur=head;
        for(int i=0;i<k;i++){
            cur=cur.next;
        }
        while (cur!=null){
            cur=cur.next;
            pre=pre.next;
        }
        return pre;
    }
}
