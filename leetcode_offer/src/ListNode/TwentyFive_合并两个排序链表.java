package ListNode;

public class TwentyFive_合并两个排序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //虚拟头结点
        ListNode fin=new ListNode(0);
        ListNode cur=fin;
        while (l1!=null&&l2!=null){
            //子链表指针一动
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            //主链表指针一动
            cur=cur.next;
        }
        //处理剩下的不为空的子链表
        cur.next=l1!=null?l1:l2;
        return fin.next;


    }
}
