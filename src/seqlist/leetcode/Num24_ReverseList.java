package seqlist.leetcode;

public class Num24_ReverseList {
    //暴力解法
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = head;
//        int num = 0;
//        while(prev.next != null){
//            prev = prev.next;
//            num++;
//        }
//        ListNode node = head;
//        for (int i = 0; i <= num; i++) {
//            ListNode newNode = new ListNode(node.val);
//            newNode.next = prev.next;
//            prev.next = newNode;
//            node = node.next;
//        }
//        return prev.next;
//    }
}
