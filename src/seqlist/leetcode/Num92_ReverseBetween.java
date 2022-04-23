package seqlist.leetcode;

public class Num92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        if(left == right){
            return head;
        }
        ListNode outPrev = null;
        ListNode cur = head;
        ListNode inPrev = null;
        ListNode outNode = null;
        ListNode leftNode = null;
        int count = 1;
        while(cur != null){
            if(count == right + 1){
                outNode = cur;
            }
            if(count < left){
                inPrev = cur;
                cur = cur.next;
            }else if(count >= left && count <= right){
                if(count == left){
                    outPrev = inPrev;
                    leftNode = cur;
                }
                ListNode next = cur.next;
                cur.next = inPrev;
                inPrev = cur;
                cur = next;
            }else{
                cur = cur.next;
            }
            count++;
        }
        if(outPrev == null && count > left){
            head.next = outNode;
            return inPrev;
        }else if(count <= left){
            return head;
        }else{
            outPrev.next = inPrev;
            leftNode.next = outNode;
            return head;
        }
    }
}
