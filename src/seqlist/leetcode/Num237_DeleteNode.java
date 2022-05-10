package seqlist.leetcode;

public class Num237_DeleteNode {
    //解法二
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //解法一
//    public void deleteNode(ListNode node) {
//        ListNode successor = node.next;
//        while(successor.next != null){
//            node.val = successor.val;
//            node = node.next;
//            successor = successor.next;
//        }
//        node.val = successor.val;
//        node.next = null;
//    }
}
