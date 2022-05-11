package seqlist.quque.impl;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(5);
        loopQueue.offer(10);
        loopQueue.offer(30);
        loopQueue.offer(50);
        loopQueue.offer(70);
        loopQueue.offer(90);
        System.out.println(loopQueue.poll());
        loopQueue.offer(100);
        System.out.println(loopQueue);
    }
}
