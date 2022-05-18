package bintree.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxHeap {
    private List<Integer> elementData;
    private int size;

    public MaxHeap() {
        this(10);
    }
    public MaxHeap(int size) {
        elementData = new ArrayList<>(size);
    }

    /**
     * 将任意的整型数组
     * @param arr
     */
    public MaxHeap(int[] arr){
        if(arr == null){
            throw new NoSuchElementException("arr is empty! cannot MaxHeap!");
        }
        //现将所有元素复制到优先级队列中
        elementData = new ArrayList<>();
        for(int i : arr){
            elementData.add(i);
            size++;
        }
        //从最后一个非叶子结点开始执行下沉操作，逐步向前，直到根结点处理完
        for (int i = parent(size - 1); i >= 0; i--) {
            siftDown(i);
        }
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

    public int extractMax(){
        if(isEmpty()){
            throw new NoSuchElementException("heap is empty! cannot extract!");
        }
        //树根就是最大值
        int max = elementData.get(0);
        //让最后一个元素覆盖掉根结点
        elementData.set(0, elementData.get(size - 1));
        //最后一个元素还没删除，因此这里要把它删掉
        elementData.remove(size - 1);
        size--;
        //让当前的首元素下沉
        siftDown(0);
        return max;
    }

    //查看堆中的队首元素
    public int getMax(){
        return elementData.get(0);
    }

    private void siftDown(int k){
        while(leftChild(k) < size){
            int j = leftChild(k);
            //判断是否存在右子树
            if(j + 1 < size && elementData.get(j + 1) > elementData.get(j)){
                //此时右子树存在且大于左子树
                j++;
            }
            //j指向子结点中最大的那个
            if(elementData.get(k) < elementData.get(j)){
                swap(k, j);
            }else{
                break;
            }
            k = j;
        }
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
