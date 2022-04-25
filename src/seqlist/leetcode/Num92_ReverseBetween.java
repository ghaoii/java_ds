package seqlist.leetcode;

public class Num92_ReverseBetween {
    //迭代
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        if(left == right){
//            return head;
//        }
//        ListNode outPrev = null;
//        ListNode cur = head;
//        ListNode inPrev = null;
//        ListNode outNode = null;
//        ListNode leftNode = null;
//        int count = 1;
//        while(cur != null){
//            if(count == right + 1){
//                outNode = cur;
//            }
//            if(count < left){
//                inPrev = cur;
//                cur = cur.next;
//            }else if(count >= left && count <= right){
//                if(count == left){
//                    outPrev = inPrev;
//                    leftNode = cur;
//                }
//                ListNode next = cur.next;
//                cur.next = inPrev;
//                inPrev = cur;
//                cur = next;
//            }else{
//                cur = cur.next;
//            }
//            count++;
//        }
//        if(outPrev == null && count > left){
//            head.next = outNode;
//            return inPrev;
//        }else if(count <= left){
//            return head;
//        }else{
//            outPrev.next = inPrev;
//            leftNode.next = outNode;
//            return head;
//        }
//    }

    //头插法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            //先保存cur的后继结点
            ListNode next = cur.next;
            cur.next = next.next;//把next单独分离出来，准备头插
            //头插
            next.next = prev.next;
            prev.next = next;
        }
        return dummyHead.next;
    }
}
