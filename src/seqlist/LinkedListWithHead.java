package seqlist;

public class LinkedListWithHead {
    private int size;//size只统计元素个数，不包括头结点
    private Node dummyHead = new Node();

    public String toString(){
        String ret = "";
        Node node = dummyHead.next;
        while(node != null){
            ret += node.data;
            ret += "->";
            node = node.next;
        }
        ret += "NULL";
        return ret;
    }

    private boolean rangeCheck(int index){
        return index >= 0 && index < size;
    }

    /**
     * 增加
     */

    //头插
    public void addFirst(int val){
        //1.
//        Node node = new Node(val);
//        node.next = dummyHead.next;
//        dummyHead.next = node;
//        size++;

        //2.
//        Node node = new Node(val, dummyHead.next);
//        dummyHead.next = node;
//        size++;

        //3.
        dummyHead.next = new Node(val, dummyHead.next);
        size++;
    }

    //在索引为index的位置插入val
    //index从第一个有效元素开始计数
    public void add(int index, int val){
        if(index < 0 || index > size){
            System.out.println("add index illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(val, prev.next);
        size++;
    }

    //尾插
    public void addLast(int val){
        add(size, val);
    }

    /**
     * 删除
     */

    //删除索引为index位置的结点
    public int remove(int index){
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = prev.next;
        prev.next = node.next;
        node.next = null;
        size--;
        //prev.next = prev.next.next;
        return node.data;
    }

    //删除链表中第一个元素值为val的结点
    public void removeValOnce(int val){
        if(dummyHead == null){
            System.out.println("LInkedList is empty");
        }
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.data != val){
                Node node = prev.next;
                prev.next = node.next;
                node.next = null;
                size--;
            }
            prev = prev.next;
        }
    }

    //删除链表中所有元素值为val的结点
    public void removeAllVal(int val){
        if(dummyHead.next == null){
            System.out.println("LinkedList is empty");
        }
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.data == val){
                Node node = prev.next;
                prev.next = node.next;
                node.next = null;
                size--;
            }else{
                prev = prev.next;
            }
        }
    }

    /**
     * 查找链表中的元素
     */

    //找出链表中第一个值为val的结点下标，否则返回-1
    public int getByVal(int val){
        int num = 0;
        Node node = dummyHead.next;
        while(node != null){
            if(node.data == val){
                return num;
            }
            num++;
            node = node.next;
        }
        return -1;
    }

    //查找链表中是否包含元素值为val的结点
    public boolean contains(int val){
        return getByVal(val) != -1;
    }

    //查找链表中下标为index的结点的元素值
    public int getByIndex(int index){
        if(!rangeCheck(index)){
            System.out.println("get index illegal");
            return -1;
        }
        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    /**
     * 修改
     */

    //将链表中索引为index的结点的元素修改为newVal，并返回修改前的元素值
    public int set(int index, int newVal){
        if(!rangeCheck(index)){
            System.out.println("set index illegal");
            return -1;
        }
        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        int oldVal = node.data;
        node.data = newVal;
        return oldVal;
    }

    //将链表中第一个元素值为oldVal的元素值改为newOld，返回是否修改成功
    public boolean setByVal(int oldVal, int newVal){
        Node node = dummyHead.next;
        while(node != null){
            if(node.data == oldVal){
                node.data = newVal;
                return true;
            }
            node = node.next;
        }
        System.out.println("oldVal does not exist");
        return false;
    }

}
