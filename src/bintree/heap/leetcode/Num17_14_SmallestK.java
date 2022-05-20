package bintree.heap.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Num17_14_SmallestK {
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if(arr == null || arr.length == 0 || k == 0){
            return ret;
        }
        //由于JDK提供的是一个最小堆，因此需要改造成一个最大堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //遍历原数组
        for (int i = 0; i < arr.length; i++) {
            if(i < k){
                queue.offer(arr[i]);
            }else{
                if(arr[i] < queue.peek()){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int i = 0;
        while(!queue.isEmpty()){
            ret[i] = queue.poll();
            i++;
        }
        return ret;
    }
}
