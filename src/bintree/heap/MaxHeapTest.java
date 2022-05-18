package bintree.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        int[] arr = {18,22,20,34,28,26,35,39,45,51};
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println(maxHeap);

//        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.add(65);
//        maxHeap.add(48);
//        maxHeap.add(29);
//        maxHeap.add(35);
//        maxHeap.add(30);
//        maxHeap.add(16);

//        System.out.println(maxHeap.getMax());

//        while(!maxHeap.isEmpty()){
//            System.out.print(maxHeap.extractMax() + " ");
//        }

//        System.out.println(maxHeap);
//        System.out.println(maxHeap.extractMax());
//        System.out.println(maxHeap);

//        System.out.println(maxHeap);
//        maxHeap.add(55);
//        System.out.println(maxHeap);
    }
}
