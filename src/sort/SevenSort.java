package sort;

public class SevenSort {
    public static void main(String[] args) {
        int n = 100000;
        int[] arr = SortHelper.generaRandomArray(n, 0, Integer.MAX_VALUE);
        //SortHelper.testSort(SortHelper.arrCopy(arr), "selectionSort");
        //SortHelper.testSort(SortHelper.arrCopy(arr), "selectionSortOP");
        SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSortBS");
        SortHelper.testSort(SortHelper.arrCopy(arr), "heapSort");
    }

    /**
     * 直接插入排序
     * 已排序区间[0, i)，第一个元素默认已经排好序
     * 待排序区间[i, n)
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //让j指向待排序元素区间的第一个元素
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                //只有当arr[j] < arr[j - 1]时，才需要移动元素，直到该元素已到达合适位置
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 折半插入排序
     * @param arr
     */
    public static void insertionSortBS(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int low = 0;
            int high = i;
            while(low <= high){
                int mid = (low + high) / 2;
                if(arr[mid] < arr[i]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            for (int j = i; j > low; j--) {
                arr[j] = arr[j - 1];
            }
            arr[low] = k;
        }
    }

    /**
     * 双向选择排序
     * @param arr
     */
    public static void selectionSortOP(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        //待排序区间 [left, right]
        while(left < right){
            int min = left;
            int max = left;
            for (int i = left + 1; i <= right; i++) {
                if(arr[i] < arr[min]){
                    min = i;
                }
                if(arr[i] > arr[max]){
                    max = i;
                }
            }
            swap(arr, min, left);
            //如果交换前的left正好是最大值，那么交换后要重新让max指向最大值
            if(max == left){
                max = min;
            }
            swap(arr, max, right);
            left++;
            right--;
        }
    }

    /**
     * 直接选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr){
        //外层循环是走的趟数，每走一趟，就有一个元素排序好了
        for (int i = 0; i < arr.length - 1; i++) {
            //选择最小值
            int min = i;
            //内层循环找到待排序元素中的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);

            //选择最大值
//            int max = 0;
//            for (int j = 1; j < arr.length - i; j++) {
//                if(arr[j] > arr[max]){
//                    max = j;
//                }
//            }
//            swap(arr, arr.length - 1 - i, max);
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    /**
     * 堆排序
     * @param arr
     */
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
