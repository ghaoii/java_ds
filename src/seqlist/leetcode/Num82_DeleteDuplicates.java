package seqlist.leetcode;

import java.util.List;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */


public class Num82_DeleteDuplicates {
    //解法1
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null){
//            return head;
//        }
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        ListNode cur = head;
//        ListNode next = cur.next;
//        while(next != null){
//            if(cur.val != next.val){
//                prev = prev.next;
//                cur = cur.next;
//                next = next.next;
//            }else{
//                while(next != null && cur.val == next.val){
//                    next = next.next;
//                }
//                prev.next = next;
//                cur = next;
//                if(next == null){
//                    break;
//                }else{
//                    next = next.next;
//                }
//            }
//        }
//        return dummyHead.next;
//    }

    //解法2
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                break;
            }
            if(cur.val != next.val){
                prev = prev.next;
                cur = cur.next;
            }else{
                while(next != null && cur.val == next.val){
                    next = next.next;
                }
                prev.next = next;
                cur = next;
            }
        }
        return dummyHead.next;
    }
}