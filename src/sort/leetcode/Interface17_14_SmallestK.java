package sort.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Interface17_14_SmallestK {
    List<Integer> tmp = new ArrayList<>();
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        smallestKInternal(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            ret[i] = tmp.get(i);
        }
        return ret;
    }

    private void smallestKInternal(int[] arr, int l, int r, int k) {
        if(l > r){
            return;
        }
        int p = partition(arr, l, r);
        if(p < k){
            tmp.add(arr[p]);
        }
        if(tmp.size() <= k){
            //如果还没全部找到继续寻找
            smallestKInternal(arr, l, p - 1, k);
            if(p < k - 1){
                //当p >= k - 1的时候，右数组无需再寻找了
                smallestKInternal(arr, p + 1, r, k);
            }
        }
    }

    private int partition(int[] arr, int l, int r) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(l, r);
        swap(arr, l, randomIndex);
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i] < v){
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
