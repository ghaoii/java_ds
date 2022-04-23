package seqlist.leetcode;

public class Num234_PalindromeLink {
    //反转链表并比较
//    public boolean isPalindrome(ListNode head) {
//        //反转链表
//        ListNode newHead = null;
//        ListNode cur = head;
//        while(cur != null){
//            newHead = new ListNode(cur.val, newHead);
//            cur = cur.next;
//        }
//        //比较链表
//        while(head != null){
//            if(head.val == newHead.val){
//                head = head.next;
//                newHead = newHead.next;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }

    //找中间结点
    public boolean isPalindrome(ListNode head) {
        //找到中间结点
        ListNode fir = head;
        ListNode sec = head;
        while(sec != null && sec.next != null){
            fir = fir.next;
            sec = sec.next.next;
        }
        //反转中间结点以后的链表
        ListNode prev = null;
        ListNode cur = fir;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //比较
        while(prev != null){
            if(prev.val == head.val){
                prev = prev.next;
                head = head.next;
            }else{
                return false;
            }
        }
        return true;
    }

}
