package bintree.heap.leetcode;

import java.util.*;

class SumNode{
    int u;
    int v;

    public SumNode(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

/**
 * 找到和最小的K对数 - 取小用大
 */

public class Num373_KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<SumNode> queue = new PriorityQueue<>(new Comparator<SumNode>() {
            @Override
            public int compare(SumNode o1, SumNode o2) {
                return o2.u + o2.v - (o1.u + o1.v);
            }
        });
        //遍历两个数组，将元素和最小的K对数存入堆中
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if(queue.size() < k){
                    queue.offer(new SumNode(nums1[i], nums2[j]));
                }else{
                    SumNode tmp = queue.peek();
                    int sum = tmp.u + tmp.v;
                    if(nums1[i] + nums2[j] < sum){
                        queue.poll();
                        queue.offer(new SumNode(nums1[i], nums2[j]));
                    }
                }
            }
        }
        //此时堆中存储的是和最小的K对数
        //遍历优先级队列，将堆中元素存入二维数组
        List<List<Integer>> ret = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            SumNode tmp = queue.poll();
            inner.add(tmp.u);
            inner.add(tmp.v);
            ret.add(inner);
        }
        return ret;
    }

}
