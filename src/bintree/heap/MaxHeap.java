package bintree.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> elementData;
    private int size;

    public MaxHeap() {
        this(10);
    }

    public void add(int val){
        elementData.add(val);
        size++;
        //上浮
        siftUp(size - 1);
    }

    //上浮操作定义
    private void siftUp(int k) {
        //当k不为根结点，且k指向的结点值大于其父结点的值时上浮
        while(k > 0 && elementData.get(k) > elementData.get(parent(k))){
            swap(k, parent(k));//交换两个索引所对应的值
            k = parent(k);//不断让k指向交换后的索引位置
        }
    }

    //传入两个索引，交换两个索引指向的值
    private void swap(int k, int parent){
        int childVal = elementData.get(k);
        int parentVal = elementData.get(parent);
        elementData.set(k, parentVal);
        elementData.set(parent, childVal);
    }


    public MaxHeap(int size) {
        elementData = new ArrayList<>(size);
    }

    public int getSize() {
        return size;
    }

    public int parent(int k){
        return (k - 1) / 2;
    }

    public int leftChild(int k){
        return k * 2 + 1;
    }

    public int rightChild(int k){
        return k * 2 + 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
        return elementData.toString();
    }
}
