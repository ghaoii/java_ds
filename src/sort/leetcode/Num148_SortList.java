package sort.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Num148_SortList {
    /**
     * 传入一个以head为头结点的链表，就能把他排序，返回排序后的链表头结点
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //找到中间结点
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //将中间结点断开
        ListNode node = head;
        while(node.next != slow){
            node = node.next;
        }
        node.next = null;
        //将两个子链表交给子函数解决
        ListNode headA = sortList(head);
        ListNode headB = sortList(slow);
        //合并操作
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(headA != null && headB != null){
            if(headA.val <= headB.val){
                tail.next = headA;
                headA = headA.next;
                tail = tail.next;
            }else{
                tail.next = headB;
                headB = headB.next;
                tail = tail.next;
            }
        }
        if(headA == null){
            tail.next = headB;
        }
        if(headB == null){
            tail.next = headA;
        }
        return dummyHead.next;
    }
}
