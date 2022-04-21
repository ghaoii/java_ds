package seqlist.leetcode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */


public class Num82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }
            if (cur.val != next.val) {
                cur = cur.next;
                prev = prev.next;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                prev.next = next;
                cur = next;
            }
        }
        return dummyHead.next;
    }
}