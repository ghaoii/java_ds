package seqlist.leetcode;

public class Num1290_GetDecimalValue {
    //解法二
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while(head != null){
            num = (num << 1) + head.val;
            head = head.next;
        }
        return num;
    }


    //解法一
//    public int getDecimalValue(ListNode head) {
//        //反转链表
//        ListNode prev = null;
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        //此时prev为新的头结点
//        int i = 0;
//        int num = 0;
//        while(prev != null){
//            num += prev.val * (int)Math.pow(2,i);
//            i++;
//            prev = prev.next;
//        }
//        return num;
//    }
}
