package sort.leetcode;

import bintree.heap.PriorityQueue;
import seqlist.quque.Queue;

import java.util.concurrent.ThreadLocalRandom;

public class Num215_FindKthLargest {
    //分区解决
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int p = partition(nums, l, r);
            if(p == nums.length - k){
                return nums[p];
            }else if(p < nums.length - k) {
                l = p + 1;
            }else{
                r = p - 1;
            }
        }
        return -1;
    }

    //分区
    private int partition(int[] nums, int l, int r) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(l, r);
        swap(nums, l, randomIndex);
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(nums[i] < v){
                swap(nums, i, j + 1);
                j++;
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //TopK解法
//    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> queue = new PriorityQueue();
//        for (int i = 0; i < nums.length; i++) {
//            if(i < k){
//                queue.offer(nums[i]);
//            }else{
//                if(nums[i] > queue.peek()){
//                    queue.poll();
//                    queue.offer(nums[i]);
//                }
//            }
//        }
//        return queue.peek();
//    }
}
