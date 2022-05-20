package bintree.heap.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Num138_RandomList {
    //尝试链表解决


    //Map解法
    public Node copyRandomList(Node head) {
        //遍历原链表，没碰到一个链表，就建立一个新的链表
        Map<Node, Node> map = new HashMap();
        Node node = head;
        while(node != null){
            map.put(node, new Node(node.val));
            node = node.next;
        }
        //给新的链表建立next和random
        for(Node x = head; x != null; x = x.next){
            map.get(x).next = map.get(x.next);
            map.get(x).random = map.get(x.random);
        }

        return map.get(head);
    }
}
