package seqlist;

public class LinkedListWithHeadTest {
    public static void main(String[] args) {
        LinkedListWithHead linkedListWithHead = new LinkedListWithHead();
        linkedListWithHead.addLast(20);
        linkedListWithHead.addLast(20);
        linkedListWithHead.addLast(20);
        linkedListWithHead.addLast(20);
        linkedListWithHead.removeAllVal(20);
        System.out.println(linkedListWithHead);

    }
}
