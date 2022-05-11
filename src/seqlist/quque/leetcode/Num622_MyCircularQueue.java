package seqlist.quque.leetcode;

import java.util.Queue;

public class Num622_MyCircularQueue {
    private Integer[] data;
    private int head;
    private int tail;

    public Num622_MyCircularQueue(int k) {
        data = new Integer[k + 1];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head + 1) % data.length;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int lastIndex = tail == 0 ? data.length - 1 : tail - 1;
        return data[lastIndex];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }
}
