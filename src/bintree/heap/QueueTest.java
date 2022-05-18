package bintree.heap;

import seqlist.quque.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue();
        int[] arr = {18,22,20,34,28,26,35,39,45,51};
        for(int i : arr){
            queue.offer(i);
        }
        System.out.println(queue.poll());
    }
}
