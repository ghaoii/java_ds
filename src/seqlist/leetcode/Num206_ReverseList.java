package seqlist.leetcode;

public class Num206_ReverseList {

    //创建新链表
//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = null;
//        while(head != null){
//            newHead = new ListNode(head.val, newHead);
//            head = head.next;
//        }
//        return newHead;
//    }

    //三引用
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //递归解法
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode node = head.next;
//        ListNode newHead = reverseList(head.next);
//        node.next = head;
//        head.next = null;
//
//        return newHead;
//    }
}
