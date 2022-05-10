package seqlist.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack<E> {
    //记录当前栈的元素个数
    private int size;
    //实际存储数据的动态数组，此时栈中只能在数组末尾添加和删除元素
    private List<E> data = new ArrayList<>();

    /**
     * 向当前栈中添加元素
     * @param val
     */
    public void push(E val){
        data.add(val);
        size++;
    }

    public E pop(){
        if(isEmpty()){
            //栈为空
            throw new NoSuchElementException("stack is empty! can not pop!");
        }
        //栈不为空
        E ret = data.remove(size - 1);
        size--;
        return ret;
    }

    public E peek(){
        if(isEmpty()){
            throw new NoSuchElementException("stack is empty! can not pop!");
        }
        return data.get(size - 1);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if(i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

    private boolean isEmpty(){
        return size == 0;
    }

}
