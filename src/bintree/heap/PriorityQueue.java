package bintree.heap;

import seqlist.quque.Queue;

import java.util.Collection;
import java.util.Iterator;

/**
 * 基于最大堆的优先级队列
 */
public class PriorityQueue implements Queue<Integer> {
    private MaxHeap heap;
    public PriorityQueue(){
        heap = new MaxHeap();
    }

    @Override
    public void offer(Integer val) {
        heap.add(val);
    }

    @Override
    public Integer poll() {
        return heap.extractMax();
    }

    @Override
    public Integer peek() {
        return heap.getMax();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
