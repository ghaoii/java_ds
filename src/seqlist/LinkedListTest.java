package seqlist;

public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(10);
        singleLinkedList.addLast(20);
        singleLinkedList.addLast(30);
        singleLinkedList.addLast(40);
        System.out.println(singleLinkedList.set(2, 300));
        System.out.println(singleLinkedList);
    }
}
