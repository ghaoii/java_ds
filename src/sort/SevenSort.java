package sort;

public class SevenSort {
    public static void main(String[] args) {
        int n = 10000000;
        //int[] arr = SortHelper.generateSortedArray(n, 10);
        int[] arr = SortHelper.generaRandomArray(n, 0, Integer.MAX_VALUE);
        //SortHelper.testSort(SortHelper.arrCopy(arr), "selectionSort");
        //SortHelper.testSort(SortHelper.arrCopy(arr), "selectionSortOP");
        //SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSort");
        //SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSort2");
        //SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSortBS");
        SortHelper.testSort(SortHelper.arrCopy(arr), "shellSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "heapSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "mergeSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "mergeSortNonRecursion");
    }

    /**
     * 迭代实现归并排序
     * @param arr
     */
    public static void mergeSortNonRecursion(int[] arr){
        //最外层的循环表示每次合并的子数组的元素个数
        //第一次子数组为1个元素，第二次为2个，第三次为4个…直到整个数组合并完成
        for(int sz = 1; sz <= arr.length; sz += sz){
            //内层循环表示merge操作，i表示每次合并操作的开始索引
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                //边界：i + sz + sz - 1 > arr.length
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, arr.length - 1));
            }
        }
    }

    public static void mergeSort(int[] arr){
        mergeSortInternal(arr, 0, arr.length - 1);
    }

    /**
     * 在arr[left, right]区间上进行归并排序
     * @param arr
     * @param left
     * @param right
     */
    private static void mergeSortInternal(int[] arr, int left, int right) {
        if(right - left <= 15) {
            //当子数组中只剩下一个元素的时候，直接返回
            insertionSort(arr, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortInternal(arr, left, mid);
        mergeSortInternal(arr, mid + 1, right);
        //让[left, mid] 和 [mid + 1, right]区间内的元素此时已经有序，仅需要将其合并即可
        if(arr[mid] > arr[mid + 1]){
            //只有当乱序的时候才进行拼接
            merge(arr, left, mid, right);
        }
    }

    /**
     * 在arr[left, right]区间进行插入排序
     * @param arr
     * @param left
     * @param right
     */
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int val = arr[i];
            int j = i;
            for(; j > left && val < arr[j - 1]; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = val;
        }
    }

    /**
     * 将有序子数组[left, mid]和[mid + 1, right]区间的两个子元素合并为一个大数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //先创建一个新的临时数组，将子数组的值复制给新数组
        int[] aux = new int[right - left + 1];
        for (int i = 0; i < aux.length; i++) {
            //aux的索引为[0, right - left)，元素的起点从i = 0开始
            //但是对arr数组来说，元素的元素的起点在left处，和i正好差了left个偏移量
            aux[i] = arr[i + left];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if(i > mid){
                //[left, mid]区间的子数组已经遍历完毕
                arr[k] = aux[j - left];
                j++;
            }else if(j > right){
                //[mid + 1, right]区间的子数组已经遍历完毕
                arr[k] = aux[i - left];
                i++;
            }else if(aux[i - left] <= aux[j - left]){
                //将aux[i - left]写回到arr[k]
                arr[k] = aux[i - left];
                i++;
            }else{
                //aux[i - left] > aux[j - left]，将aux[j - left]写回arr[k]中
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

    /**
     * 希尔排序 - 基于优化后的插入排序的希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        int gap = arr.length >> 1;
        while(gap >= 1){
            for (int i = gap; i < arr.length; i++) {
                int val =arr[i];
                int j = i;
                for(; j >= gap && val < arr[j - gap]; j -= gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = val;
            }
            gap = gap >> 1;
        }
    }

    /**
     * 希尔排序 - 按照gap将原数组分为gap个子数组，子数组内部先排序，不断缩小gap值，直到gap = 1
     * @param arr
     */
//    public static void shellSort(int[] arr){
//        int gap = arr.length >> 1;
//        //预处理阶段，当gap == 1的时候，最后进行一次插入排序
//        while(gap >= 1){
//            //按照gap分组，组内进行插入排序
//            insertionByGap(arr, gap);
//            gap = gap >> 1;
//        }
//    }
//
//    private static void insertionByGap(int[] arr, int gap) {
//        for (int i = gap; i < arr.length; i++) {
//            for (int j = i ; j >= gap && arr[j] < arr[j - gap]; j -= gap) {
//                arr[j] = arr[j - gap];
//            }
//        }
//    }


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
     * 优化后的直接插入排序，当待排序元素小于前一个元素的时候，不再两两交换
     * 而是不断向后搬移元素，直到待排序元素大于或等于前一个元素时，其所在位置就是插入位置
     * 减少了调用swap方法的时间
     * @param arr
     */
    public static void insertionSort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //让j指向待排序元素区间的第一个元素
            int val = arr[i];
            int j = i;
            for (; j >= 1 && val < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = val;
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
