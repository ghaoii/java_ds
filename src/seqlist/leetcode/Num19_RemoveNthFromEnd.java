package seqlist.leetcode;

public class Num19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先找到待删除结点和前驱
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(fast != null){
            fast = fast.next;
            count++;
            if(count > n){
                prev = prev.next;
                slow = slow.next;
            }
        }
        prev.next = slow.next;
        return dummyHead.next;
    }
}
