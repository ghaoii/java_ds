package bintree.heap.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Num1046_LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i : stones){
            queue.offer(i);
        }
        int a = queue.poll();
        while(!queue.isEmpty()){
            int b = queue.poll();
            //a肯定大于等于b,因此让a - b
            if(a - b > 0){
                queue.offer(a - b);
            }
            if(!queue.isEmpty()){
                a = queue.poll();
            }else{
                return 0;
            }
        }
        return a;
    }
}
