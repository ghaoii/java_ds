package seqlist.quque;

public interface Queue<E> {
    //入队
    void offer(E e);
    //出队
    E poll();
    //查看当前队首元素
    E peek();

    boolean isEmpty();
}
