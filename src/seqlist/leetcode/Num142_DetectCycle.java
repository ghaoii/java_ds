package seqlist.leetcode;

public class Num142_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if(fast == low){
                ListNode node = head;
                while(node != low){
                    node = node.next;
                    low = low.next;
                }
                return low;
            }
        }
        return null;
    }
}
