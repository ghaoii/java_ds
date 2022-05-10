package seqlist.leetcode;

import java.util.List;

public class Num25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null){
            while(fast != null && count != k){
                fast = fast.next;
                count++;
            }
            if(count == k){
                for (int i = 0; i < k - 1; i++) {
                    ListNode successor = slow.next;
                    slow.next = successor.next;
                    successor.next = prev.next;
                    prev.next = successor;
                }
                prev = slow;
                slow = slow.next;
                count = 0;
            }
        }
        return dummyHead.next;
    }
}
