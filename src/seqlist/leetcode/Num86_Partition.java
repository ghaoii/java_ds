package seqlist.leetcode;

public class Num86_Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode bigHead = new ListNode();
        ListNode stail = smallHead;
        ListNode btail = bigHead;
        while(head != null){
            if(head.val < x){
                stail.next = head;
                stail = head;
            }else{
                btail.next = head;
                btail = head;
            }
            head = head.next;
        }
        stail.next = bigHead.next;
        btail.next = null;
        return smallHead.next;
    }
}
