package seqlist;

public class DoubleLinkTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(20);
        doubleLinkedList.addLast(20);
        doubleLinkedList.addLast(20);
        doubleLinkedList.addLast(20);
        doubleLinkedList.removeValAll(20);
        System.out.println(doubleLinkedList);
    }
}
