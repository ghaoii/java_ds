package seqlist.leetcode;

import java.util.List;

public class Num2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(l1 != null || l2 != null){
            int count = 0;
            if(l1 != null){
                count += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                count += l2.val;
                l2 = l2.next;
            }
            count += tmp;
            tail.next = new ListNode(count % 10);
            tail = tail.next;
            tmp = count / 10;
        }
        if(tmp > 0){
            tail.next = new ListNode(tmp);
        }
        return dummyHead.next;
    }
}
