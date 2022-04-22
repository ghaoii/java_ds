package seqlist.leetcode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */


public class Num83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        while (cur != null) {
//            //解法二
//            while (cur != null && prev.val == cur.val) {
//                cur = cur.next;
//            }
//            prev.next = cur;
//            prev = prev.next;
//
        // 解法一
            if(prev.val != cur.val){
                prev.next = cur;
                prev = prev.next;
            }
            cur = cur.next;
        }
        prev.next = null;
        return head;
    }
}

