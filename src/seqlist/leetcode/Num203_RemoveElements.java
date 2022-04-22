package seqlist.leetcode;

import java.util.List;




public class Num203_RemoveElements {

    /**
     * 通过带头链表解决
     */
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        while(prev.next != null){
//            if(prev.next.val == val){
//                prev.next = prev.next.next;
//            }else{
//                prev = prev.next;
//            }
//        }
//        return dummyHead.next;
//    }


    /**
     * 递归解决
     * 语义：我们调用这个函数，就能删除链表中的值为val的结点，并返回新的结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
//        if(head.val == val){
//            head = head.next;
//        }
//        return head;

        return head.val == val ? head.next : head;
    }



    //循环解决
//    public ListNode removeElements(ListNode head, int val) {
//        //判断头结点是否为待删除元素，如果是则删除头结点
//        while (head != null && head.val == val) {
//            head = head.next;
//        }
//        //如果此时链表为空，则返回null
//        if(head == null){
//            return null;
//        }
//        //如果待删除元素不在头结点
//        ListNode node = head;
//        //保证node的下个元素存在，否则会越界
//        while(node.next != null){
//            //
//            if(node.next.val == val){
//                ListNode x = node.next;
//                node.next = x.next;
//            }else{
//                node = node.next;
//            }
//        }
//        return head;
//    }
}
