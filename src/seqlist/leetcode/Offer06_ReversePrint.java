package seqlist.leetcode;

public class Offer06_ReversePrint {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode prev = null;
        ListNode cur = head;
        int num = 0;
        //反转链表
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            num++;
        }
        //打印入数组
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = prev.val;
            prev = prev.next;
        }
        return arr;
    }
}
