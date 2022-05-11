package seqlist.quque.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Num225_MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

//public class Num225_MyStack {
//    private Queue<Integer> q1 = new LinkedList<>();
//    private Queue<Integer> q2 = new LinkedList<>();
//
//    public void push(int x) {
//        q2.offer(x);
//        while(!q1.isEmpty()){
//            q2.offer(q1.poll());
//        }
//        Queue<Integer> tmp = q2;
//        q2 = q1;
//        q1 = tmp;
//    }
//
//    public int pop() {
//        return q1.poll();
//    }
//
//    public int top() {
//        return q1.peek();
//    }
//
//    public boolean empty() {
//        return q1.isEmpty();
//    }
//}
