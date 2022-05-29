package sort.leetcode;

public class Off51_ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if(l >= r){
            return 0;
        }
        int mid = l + (r - l) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        if(nums[mid] > nums[mid + 1]){
            return count + merge(nums, l, mid, r);
        }
        return count;
    }

    private int merge(int[] nums, int l, int mid, int r) {
        //把两个子数组的所有内容都拷贝入新数组aux中
        int[] aux = new int[r - l + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = nums[i + l];
        }
        int i = l;
        int j = mid + 1;
        int count = 0;
        for (int k = l; k <= r; k++) {
            if(i > mid){
                //左数组已经遍历完了
                nums[k] = aux[j - l];
                j++;
            }else if(j > r){
                //右数组已经遍历完了
                nums[k] = aux[i - l];
                i++;
            }else if(aux[i - l] <= aux[j - l]){
                nums[k] = aux[i - l];
                i++;
            }else{
                //右数组的元素值如果小于左数组
                //此时，aux[j - l]与左数组中[i, mid]区间中的所有元素都构成逆序对
                nums[k] = aux[j - l];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }
}
