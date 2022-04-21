package seqlist;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {

    }
}

public class SingleLinkedList {
    private Node head;
    private int size;

    //toString
    public String toString() {
        Node x = head;
        String ret = "";
        while (x != null) {
            ret += x.data;
            ret += "->";
            x = x.next;
        }
        ret += "NULL";
        return ret;
    }

    private boolean indexLegal(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }


    /**
     * 向当前链表中添加元素
     */

    //头插法
    public void addFirst(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
    }

    //在index处插入
    public void addIndex(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("add index is illegal");
            return;
        }
        //如果是下标是0，则是头插
        if (index == 0) {
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
    public void addLast(int val) {
        addIndex(size, val);
    }


    /**
     * 在链表中查找元素
     */

    //在链表中找到值为val的元素，并返回下标，否则返回-1
    public int getByval(int val) {
        Node node = head;
        int num = 0;
        while (node != null) {
            if (node.data == val) {
                return num;
            }
            num++;
            node = node.next;
        }
        return -1;
    }
//    //写法二
//    public int getByval(int val) {
//        int index = 0;
//        for (Node node = head; node != null; i++) {
//            if (node.data == val) {
//                return i;
//            }
//            node = node.next;
//        }
//        return -1;
//    }

    //查找链表中是否包含val
    public boolean contains(int val) {
        return getByval(val) != -1;
    }

    //查找链表中，下标为index的元素值
    public int getByIndex(int index) {
        if (!indexLegal(index)) {
            System.out.println("get index is illegal");
            return -1;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    /**
     * 修改链表中的元素
     */

    //将下标为index的结点的值修改为newVal，并返回旧的值
    public int set(int index, int newVal) {
        if (!indexLegal(index)) {
            System.out.println("set index is illegal");
            return -1;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        int oldVal = node.data;
        node.data = newVal;
        return oldVal;
    }

    /**
     * 删除链表中的元素
     */

    //删除索引为index位置的元素，返回删除前的元素值
    public int remove(int index) {
        if (!indexLegal(index)) {
            System.out.println("remove index illegal");
            return -1;
        }
        if (index == 0) {
            Node prev = head;
            head = head.next;
            prev.next = null;
            size--;
            return prev.data;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            node.next = null;
            size--;
            return node.data;
        }
    }

    //删除链表中第一个值为val的节点，返回是否删除成功
    public void removeValOnce(int val) {
        if (head == null) {
            System.out.println("LinkedList is empty");
        }
        //头结点就是待删除元素
        if (head.data == val) {
            Node x = head;
            head = x.next;
            x.next = null;
            size--;
            return;
        }

        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data == val) {
                Node x = prev.next;
                prev.next = x.next;
                x.next = null;
            }
            prev = prev.next;
        }
        System.out.println("val is not existing");
    }

    //删除链表中所有值为val的结点
    public void removeAllVal(int val) {
        //如果头结点是待删除元素
        while (head != null && head.data == val) {
            Node x = head;
            head = x.next;
            x.next = null;
            size--;
        }
        //如果整个链表都已经删完了，直接退出
        if (head == null) {
            return;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data == val) {
                Node x = prev.next;
                prev.next = x.next;
                x.next = null;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }

    //删除头结点
    public void removeFirst() {
        remove(0);
    }

    //删除尾结点
    public void removeLast() {
        remove(size - 1);
    }

}
