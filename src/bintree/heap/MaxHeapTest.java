package bintree.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(65);
        maxHeap.add(48);
        maxHeap.add(29);
        maxHeap.add(35);
        maxHeap.add(30);
        maxHeap.add(16);
        System.out.println(maxHeap);
        maxHeap.add(55);
        System.out.println(maxHeap);
    }
}
