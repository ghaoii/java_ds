package seqlist;

public class DoubleLinkTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(50);
        doubleLinkedList.addFirst(30);
        doubleLinkedList.addFirst(10);
        System.out.println(doubleLinkedList);
    }
}
