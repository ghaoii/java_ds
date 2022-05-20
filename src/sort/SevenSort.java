package sort;

import java.util.Arrays;

public class SevenSort {
    public static void main(String[] args) {
        int arr[] = { 19, 28, 32, 15, 25, 22, 18 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //先把数组堆化，构建为一个最大堆
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
        //此时数组已经构建为一个最大堆，我们不断将队首元素和末尾元素进行交换，然后让新队首元素不断下沉
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);//交换队首元素放到最终位置
            siftDown(arr, 0, i);//将新的队首元素下沉
        }
        //走到这里堆排序就完成了
    }

    /**
     *
     * @param arr
     * @param i // 需要下沉的元素的下标
     * @param length // 数组的长度
     */
    private static void siftDown(int[] arr, int i, int length) {
        while(2 * i + 1 < length){
            int j = 2 * i + 1;
            if(j + 1 < length && arr[j + 1] > arr[j]){
                //如果待下沉元素有右结点，且右结点大于左结点，则让j指向右结点
                j++;
            }
            //走到这里j一定是左右子树中较大者
            if(arr[i] < arr[j]){
                //如果子树结点值大于根结点的就交换
                swap(arr, i, j);
                i = j;
            }else{
                //如果根结点已经大于子结点，说明该优先级队列仍然满足最大堆
                //因此直接退出siftDown操作即可，否则死循环
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}
