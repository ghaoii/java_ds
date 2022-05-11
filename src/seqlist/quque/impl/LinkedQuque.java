package seqlist.quque.impl;

import seqlist.quque.Quque;

import java.util.NoSuchElementException;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}


public class LinkedQuque<E> implements Quque<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    @Override
    public void offer(E data) {
        Node<E> node = new Node<>(data);
        if(isEmpty()){
            tail = head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;

//        if(isEmpty()){
//            head = tail = new Node<E>(data);
//        }else{
//            tail.next = new Node<E>(data);
//            tail = tail.next;
//        }
//        size++;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            throw new NoSuchElementException("Quque is empty! can not poll!");
        }
        E ret = head.data;
        Node<E> node = head;
        head = head.next;
        node.next = node = null;
        size--;
        return ret;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Quque is empty! can not peek!");
        }
        return head.data;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("front [");
        Node<E> node = head;
        while(node != null){
            sb.append(node.data);
            if(node.next != null){
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("] tail");
        return sb.toString();
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
