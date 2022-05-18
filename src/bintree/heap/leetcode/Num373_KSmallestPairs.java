package bintree.heap.leetcode;

import java.util.*;

public class Num373_KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return add(o2) - add(o1);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> inner = new ArrayList<>();
                inner.add(nums1[i]);
                inner.add(nums2[j]);
                if(queue.size() < k){
                    queue.offer(inner);
                }else{
                    if(add(inner) < add(queue.peek())){
                        queue.poll();
                        queue.offer(inner);
                    }
                }
            }
        }

        List<List<Integer>> ret = new ArrayList<>();
        while(!queue.isEmpty()){
            ret.add(queue.poll());
        }
        return ret;
    }

    private int add(List<Integer> arr){
        return arr.get(0) + arr.get(1);
    }
}
