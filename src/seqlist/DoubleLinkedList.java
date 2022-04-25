package seqlist;


class DoubleNode{
    DoubleNode prev;
    int val;
    DoubleNode next;

    public DoubleNode() {}

    public DoubleNode(DoubleNode prev, int val, DoubleNode next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}

public class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public String toString(){
        DoubleNode cur = head;
        String ret = "";
        while(cur != null){
            ret += cur.val;
            ret += "->";
            cur = cur.next;
        }
        ret += "NULL";
        return ret;
    }

    /**
     * 链表的插入
     */

    //头插
    public void addFirst(int val){
        if(head == null){
            //链表为空
            DoubleNode node = new DoubleNode();
            node.val = val;
            head = node;
            tail = node;
        }else{
            DoubleNode node = new DoubleNode(null, val, head);
            head.prev = node;
            head = node;
        }
        size++;
    }


}
