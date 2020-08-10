package ListNode;

public class FiftyTwo_两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode tempA=headA;
        ListNode tempB=headB;
        int count=0;
        while (tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
            if(tempA==null){
                tempA=headB;
                count++;
            }
            if(tempB==null){
                tempB=headA;
                count++;
            }
            if (count>2)return null;
        }
        return tempA;




    }

}
