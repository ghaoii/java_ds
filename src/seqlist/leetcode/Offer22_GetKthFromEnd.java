package seqlist.leetcode;

public class Offer22_GetKthFromEnd {

    //暴力求解
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        int count = 0;
//        for(ListNode x = head; x != null; x = x.next){
//            count++;
//        }
//        for (int i = 0; i < count - k; i++) {
//            head = head.next;
//        }
//        return head;
//    }

    //快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k <= 0){
            return head;
        }
        ListNode fir = head;
        ListNode sec = head;
        int count = 0;
        while(sec != null){
            sec = sec.next;
            count++;
            if(count > k){
                fir = fir.next;
            }
        }
        if(count < k){
            return null;
        }
        return fir;
    }

}
