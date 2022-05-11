package seqlist.quque.impl;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
//        LinkedQuque<Integer> queue = new LinkedQuque<>();
//        queue.offer(10);
//        queue.offer(30);
//        queue.offer(50);
//        queue.offer(70);
//        System.out.println(queue);
//        System.out.println(queue.pull());
//        System.out.println(queue);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(30);
        queue.offer(50);
        queue.offer(70);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
