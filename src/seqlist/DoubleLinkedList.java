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

    //封装一个寻找索引的函数
    private DoubleNode findNode(int index){
        DoubleNode node = null;
        if(index < size/2){
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }else{
            node = tail;
            for (int i = size - 1; i > index ; i--) {
                node = node.prev;
            }
        }
        return node;
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

    //尾插
    public void addLast(int val){
        if(tail == null){
            //此时链表为空
            DoubleNode node = new DoubleNode();
            node.val = val;
            tail = node;
            head = node;
        }else{
            //此时链表不为空
            DoubleNode node = new DoubleNode(tail, val, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //在索引为index处插入
    public void add(int index, int val){
        if(index < 0 || index > size){
            System.out.println("add index illegal");
            return;
        }
        if(index == 0){
            //头插
            addFirst(val);
        }else if(index == size){
            //尾插
            addLast(val);
        }else{
            //找到结点
            DoubleNode node = findNode(index);
            DoubleNode newNode = new DoubleNode(node.prev, val, node);
            newNode.prev.next = newNode;
            node.prev = newNode;
        }
        size++;
    }

    /**
     * 双向链表的查找
     */

    //找到索引为index的结点的元素值
    public int findByIndex(int index){
        DoubleNode node = findNode(index);
        return node.val;
    }

    //找到链表中第一个元素值为val的结点，返回其索引，否则返回-1
    public int findByVal(int val){
        DoubleNode node = head;
        int count = 0;
        while(node != null){
            if(node.val == val){
                return count;
            }
            node = node.next;
            count++;
        }
        System.out.println("val does not exist");
        return -1;
    }

    /**
     * 修改双向链表中的元素
     */

    //修改索引为index的结点的元素值，返回修改前的元素值
    public int set(int index, int newVal){
        if(index < 0 || index >= size){
            System.out.println("set index illegal");
            return -1;
        }
        DoubleNode node = findNode(index);
        int oldVal = node.val;
        node.val = newVal;
        return oldVal;
    }

    /**
     * 删除链表中的结点
     */

    //封装一个删除结点的方法
    private void unlink(DoubleNode node){
        //先提前保存前驱和后继
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;
        //分治
        if(prev == null){
            head.next = null;
            head = next;
        }else{
            prev.next = next;
            node.prev = null;
        }
        if(next == null){
            tail.prev = null;
            tail = prev;
        }else{
            next.prev = prev;
            node.next = null;
        }
    }

    //删除索引为index的结点的元素值
    public void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("remove index illegal");
            return;
        }
        DoubleNode node = findNode(index);
        unlink(node);
        size--;
    }

    //删除链表中第一个元素值为val的结点
    public void removeValOnce(int val){
        DoubleNode node = head;
        while(node != null){
            if(node.val == val){
                unlink(node);
                size--;
                return;
            }
            node = node.next;
        }
        System.out.println("val does not exist");
    }

    //删除链表中所有值为val的结点
    public void removeValAll(int val){
        DoubleNode node = head;
        while(node != null){
            DoubleNode next = node.next;
            if(node.val == val){
                unlink(node);
            }
            node = next;
        }
    }

}
