package seqlist.leetcode;

public class Num160_IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;
        while(list1 != list2){
//            if(list1 == null){
//                list1 = headB;
//            }else{
//                list1 = list1.next;
//            }
//            if(list2 == null){
//                list2 = headA;
//            }else{
//                list2 = list2.next;
//            }

            list1 = list1 == null ? headB : list1.next;
            list2 = list2 == null ? headA : list2.next;

        }
        return list1;
    }
}
