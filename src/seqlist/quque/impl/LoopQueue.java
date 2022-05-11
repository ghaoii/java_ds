package seqlist.quque.impl;

import seqlist.quque.Quque;

import java.util.NoSuchElementException;
import java.util.Queue;

public class LoopQueue implements Quque<Integer> {
    private Integer[] data;
    private int head;
    private int tail;

    public LoopQueue(int size){
        data = new Integer[size + 1];
    }

    @Override
    public void offer(Integer e) {
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("LoopQueue is full! can not offer!");
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public Integer poll() {
        if(isEmpty()){
            throw new NoSuchElementException("LoopQueue is empty! can not poll!");
        }
        Integer ret = data[head];
        head = (head + 1) % data.length;
        return ret;
    }

    @Override
    public Integer peek() {
        if(isEmpty()){
            throw new NoSuchElementException("LoopQueue is empty! can not peek!");
        }
        return data[head];
    }

    public boolean isEmpty(){
        return tail == head;
    }

    public boolean isFull(){
        return (tail + 1) % data.length == head;
    }

    public String toString(){
        //也可以这么写
//        StringBuilder sb = new StringBuilder();
//        sb.append("head [");
//        int lastIndex = tail == 0 ? data.length - 1 : tail - 1;
//        for(int i = head; i != tail; ){
//            sb.append(data[i]);
//            if(i != lastIndex){
//                sb.append(", ");
//            }
//            i = (i + 1) % data.length;
//        }
//        sb.append("] tail");
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        sb.append("head [");
        for(int i = head; i != tail; ){
            sb.append(data[i]);
            if((i + 1) % data.length != tail){
                sb.append(", ");
            }
            i = (i + 1) % data.length;
        }
        sb.append("] tail");
        return sb.toString();
    }

}
