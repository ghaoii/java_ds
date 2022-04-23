package seqlist.leetcode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */


public class Num83_DeleteDuplicates {
    //解法一
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode prev = head;
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode cur = head.next;
//        while (cur != null) {
//            if (prev.val != cur.val) {
//                prev.next = cur;
//                prev = prev.next;
//            }
//            cur = cur.next;
//        }
//        prev.next = null;
//        return head;
//    }

    //解法二
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode prev = head;
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode cur = head.next;
//        while (cur != null) {
//            while (cur != null && prev.val == cur.val) {
//                cur = cur.next;
//            }
//            prev.next = cur;
//            prev = prev.next;
//        }
//        return head;
//    }

    //解法三
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = head;
//        ListNode cur = prev.next;
//        while(cur != null){
//            if(cur.val != prev.val){
//                prev = prev.next;
//            }else{
//                prev.next = cur.next;
//            }
//            cur = cur.next;
//        }
//        return head;
//    }

    //递归
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            return head.next;
        }
        return head;
    }

}

