package seqlist.quque.impl;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        //实现栈
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(10);
//        stack.push(30);
//        stack.push(50);
//        System.out.println(stack.pop());

        //实现队列
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(30);
        queue.offer(50);
        System.out.println(queue.poll());

    }
}
