package seqlist.leetcode;

public class Interface_02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        while(node != null){
            ListNode prev = node;
            ListNode cur = prev.next;
            while(cur != null){
                ListNode successor = cur.next;
                if(node.val == cur.val){
                    prev.next = successor;
                }else{
                    prev = prev.next;
                }
                cur = successor;
            }
            node = node.next;
        }
        return head;
    }
}
