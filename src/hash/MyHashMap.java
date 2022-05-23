package hash;

import java.util.NoSuchElementException;

/**
 * 当前哈希表中保存的结点，key -> value的键值对对象
 */
class Node {
    //对key值进行哈希函数运算，得到索引
    int key;
    int value;
    //存储下一个结点地址
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap {
    Node[] hashTable;
    int size;

    public MyHashMap() {
        this(16);
    }

    private int M;

    private static final double LOAD_FACTOR = 0.75;

    public MyHashMap(int init) {
        hashTable = new Node[init];
        this.M = init;//取模数与数组的长度相同
    }

    public int hash(int key) {
        return Math.abs(key % M);
    }

    /**
     * 将一对键值对 key -> value 保存到数组中
     * 若key值已经存在，则修改原value值，最终返回
     *
     * @param key
     * @param val
     * @return
     */
    public int put(int key, int val) {
        //对key进行哈希运算
        int index = hash(key);

        Node node = hashTable[index];
        while (node != null) {
            if (node.key == key) {
                //如果key值已经存在了
                int oldValue = node.value;
                node.value = val;//更新value为新的val
                return oldValue;//返回修改前的值
            }
            node = node.next;
        }
        //此时链表中不包含key的结点，头插到链表中(不用头插也可以)
        Node newNode = new Node(key, val);
        newNode.next = hashTable[index];
        hashTable[index] = newNode;
        size++;
        //每次添加元素之后判断是否要扩容
        if (size >= hashTable.length * LOAD_FACTOR) {
            resize();
        }
        return val;
    }

    private void resize() {
        //让新的哈希表的长度扩大一倍
        Node[] newHash = new Node[hashTable.length << 1];
        this.M = newHash.length;//取模数同时更新
        //遍历每个数组元素
        for (int i = 0; i < hashTable.length; i++) {
            //遍历数组中的链表，对每个结点进行搬移操作
            for (Node node = hashTable[i]; node != null; ) {
                Node next = node.next;//暂存原链表的后继结点，要不然搬移之后就找不到后继结点了！
                int index = hash(node.key);//重新计算当前结点将要存放的索引值
                //头插到新数组index处的链表中
                node.next = newHash[index];
                newHash[index] = node;
                //继续处理下一个结点
                node = next;
            }
        }
        //所有结点搬移之后，让hashTable指向新的数组
        hashTable = newHash;
    }

    /**
     * 判断当前key值是否在表中存在
     * @param key
     * @return
     */
    public boolean containKey(int key) {
        int index = hash(key);
        for(Node node = hashTable[index]; node != null; node = node.next){
            if(node.key == key){
                return true;
            }
        }
        return false;
    }

    public boolean containValue(int val){
        for (int i = 0; i < hashTable.length; i++) {
            for(Node node = hashTable[i]; node != null; node = node.next){
                if(node.value == val){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断(key, value)是否在表中存在
     * @param key
     * @param val
     * @return
     */
    public boolean contains(int key, int val){
        int index = hash(key);
        for(Node node = hashTable[index]; node != null; node = node.next){
            if(node.key == key && node.value == val){
                return true;
            }
        }
        return false;
    }

    public boolean remove(int key, int val){
        int index = hash(key);
        Node head = hashTable[index];
        if(head != null){
            if(head.key == key && head.value == val){
                //如果头结点就是待删除元素
                hashTable[index] = head.next;
                head.next = head = null;
                size--;
                return true;
            }
            //头结点不是待删除元素
            Node prev = head;
            while(prev.next != null){
                Node cur = prev.next;
                if(cur.key == key && cur.value == val){
                    prev.next = cur.next;
                    cur.next = cur = null;
                    size--;
                    return true;
                }
                prev = cur;
            }

        }
        //走到这里，说明该键值对不存在
        throw new NoSuchElementException("key -> value does not exist! cannot remove!");
    }

}
