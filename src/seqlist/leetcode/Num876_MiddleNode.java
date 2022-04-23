package seqlist.leetcode;

public class Num876_MiddleNode {
    //暴力求解
//    public ListNode middleNode(ListNode head) {
//        int count = 0;
//        for(ListNode x = head; x != null; x = x.next){
//            count++;
//        }
//        ListNode middle = head;
//        for (int i = 0; i < count / 2; i++) {
//            middle = middle.next;
//        }
//        return middle;
//    }

    //快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode fir = head;
        ListNode sec = head;
        while(sec != null && sec.next != null){
            fir = fir.next;
            sec = sec.next.next;
        }
        return fir;
    }

}
