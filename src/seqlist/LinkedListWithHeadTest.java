package seqlist;

public class LinkedListWithHeadTest {
    public static void main(String[] args) {
        LinkedListWithHead linkedListWithHead = new LinkedListWithHead();
        linkedListWithHead.addLast(10);
        linkedListWithHead.addLast(20);
        linkedListWithHead.addLast(30);
        linkedListWithHead.addLast(40);
        System.out.println(linkedListWithHead.setByVal(0, 300));
        System.out.println(linkedListWithHead);

    }
}
