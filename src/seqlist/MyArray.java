package seqlist;

import java.util.Arrays;

public class MyArray {
    private int[] data;
    private int size = 0;

    /**
     * 向动态数组中添加元素
     */
    //向数组的末尾增加元素
    public void add(int val){
        data[size] = val;
        size++;
        //如果数组满了，则扩容
        if(size == data.length){
            grow();
        }
    }

    //向index索引处添加新元素
    public boolean add(int index, int val){
        if(index < 0 || index > size){
            System.out.println("index is illegal");
            return false;
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = val;
        size++;

        if(size == data.length){
            grow();
        }
        return true;
    }

    //扩容 - 设置为私有，因为用户不会手动调用到，且用户也不知道什么时候数组满了
    private void grow() {
        this.data = Arrays.copyOf(data, data.length * 2);
    }

    /**
     * 查找动态数组中的元素
     */
    //根据元素值查找数组中第一次出现的此元素，找到了返回索引，否则返回-1
    public int getByValue(int val){
        for (int i = 0; i < size; i++) {
            if(data[i] == val){
                return i;
            }
        }
        return -1;
    }

    //查找当前动态数组中含有val，有则返回true，否则返回false
    public boolean contains(int val){
        return getByValue(val) != -1;
    }

    //查找当前数组中，索引为index的元素,找到返回元素值，否则返回-1
    public int getByIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("index is illegal");
            return -1;
        }
        return data[index];
    }

    /**
     * 修改动态数组中的元素
     */
    //修改索引为index的元素，并返回修改前的值，否则返回-1
    public int setByIndex(int index, int newVal){
        if(index < 0 || index >= size){
            System.out.println("index is illegal");
            return -1;
        }
        int ret = data[index];
        data[index] = newVal;
        return ret;
    }

    //修改动态数组中第一个元素值为oldVal的元素，修改成功，返回true，否则返回false
    public boolean setByVal(int oldVal, int newVal){
        int index = getByValue(oldVal);
        if(index == -1){
            System.out.println("oldVal is not exist");
            return false;
        }
        data[index] = newVal;
        return true;
    }

    /**
     * 删除动态数组中的元素
     */
    //删除当前动态数组中索引为index的元素,删除成功返回删除前的值，否则返回-1
    public int removeIndex(int index){
        //若动态数组中没有元素返回-1
        if (size == 0) {
            System.out.println("seqlist is empty");
            return -1;
        }
        if(index < 0 || index >= size){
            System.out.println("index is illegal");
            return -1;
        }
        int ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        //data[size - 1] = 0;
        size--;
        return ret;
    }

    //删除动态数组的头元素，若动态数组为空，返回-1
    public int removeFirst(){
        return removeIndex(0);
    }

    //删除动态述责的尾元素,若动态数组为空，返回-1
    public int removeLast(){
        return removeIndex(size - 1);
    }

    //删除第一个元素值为val的元素，删除成功返回true，否则返回false
    public boolean removeByValFirst(int val){
        int index = getByValue(val);
        if(index == -1){
            System.out.println("value is not exist");
            return false;
        }
       return removeIndex(index) != -1;
    }

    //删除所有元素值为val的元素值，删除成功返回true，否则返回false
    public void removeByValAll(int val){
        for (int i = 0; i < size; i++) {
            while( i < size && data[i] == val){
                removeIndex(i);
            }
        }

//        boolean ret = false;
//        for (int i = size - 1; i >= 0; i--) {
//            if(data[i] == val){
//                removeIndex(i);
//                ret = true;
//            }
//        }
//        if(!ret){
//            System.out.println("val does not exist");
//            return false;
//        }
//        return getByValue(val) == -1;
    }

    //无参构造
    public MyArray(){
        this(10);
    }

    //有参构造
    public MyArray(int initCap){
        this.data = new int[initCap];
    }

    public String toString(){
        String ret = "[";
        for (int i = 0; i < size; i++) {
            ret += data[i];
            if(i < size - 1){
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

}
