package seqlist;


class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    public Node(){

    }
}

public class SingleLinkedList {
    private Node head;
    private int size;

    //toString
    public String toString(){
        Node x = head;
        String ret = "";
        while(x != null){
            ret += x.data;
            ret += "->";
            x = x.next;
        }
        ret += "NULL";
        return ret;
    }


    /**
     * 向当前链表中添加元素
     */

    //头插法
    public void addFirst(int val){
        Node node = new Node(val);
        if(head != null){
            node.next = head;
        }
        head = node;
        size++;
    }

    //在index处插入
    public void addIndex(int index, int val){
        if(index < 0 || index > size){
            System.out.println("add index is illegal");
            return;
        }
        //如果是下标是0，则是头插
        if(index == 0){
            addFirst(val);
            return;
        }
        //先找到index的前驱
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    //尾插法
    public void addLast(int val){
        addIndex(size, val);
    }


    /**
     * 在链表中查找元素
     */

    //在链表中找到值为val的元素，并返回下标，否则返回-1
    public int getByval(int val){
        Node prev = head;
        int num = 0;
        while(prev != null){
            if(prev.data == val){
                return num;
            }
            num++;
            prev = prev.next;
        }
        return -1;
//        for (int i = 0; prev != null && i < size; i++) {
//            if(prev.data == val){
//                return i;
//            }
//            prev = prev.next;
//        }
//        return -1;
    }

    //查找链表中是否包含val
    public boolean contains(int val){
        return getByval(val) != -1;
    }

    //超找链表中，下标为index的元素值
    public int getByIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("get index is illegal");
            return -1;
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.data;
    }

    /**
     * 修改链表中的元素
     */

    //将下标为index的结点的值修改为newVal，并返回旧的值
    public int set(int index, int newVal){
        if(index < 0 || index >= size){
            System.out.println("set index is illegal");
            return -1;
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        int ret = prev.data;
        prev.data = newVal;
        return ret;
    }

    /**
     * 删除链表中的元素
     */

    //删除索引为index位置的元素

}
