package bintree.heap.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 出现频率最高的k个元素 - 取大用小
 */

    //这个类的对象存储了数组中的元素以及其出现的次数
    //在优先级队列中，就添加该类的对象即可
class Node{
    //数组中出现过的元素值
    int val;
    //数组中该元素出现的次数
    int occ;

    public Node(int val, int occ) {
        this.val = val;
        this.occ = occ;
    }
}

//通过Map辅助解决问题
public class Num347_TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        //遍历原数组，将数组元素和出现次数存储到Map中
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                //说明map中以及存有该元素，只需要让出现次数加1即可
                int times = map.get(i);
                map.put(i, times + 1);
            }else{
                map.put(i, 1);
            }
        }
        //数组遍历完了
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.occ - o2.occ;
            }
        });
        //遍历Map集合，构建最小堆
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(queue.size() < k){
                queue.offer(new Node(entry.getKey(), entry.getValue()));
            }else{
                if(entry.getValue() > queue.peek().occ){
                    queue.poll();
                    queue.offer(new Node(entry.getKey(), entry.getValue()));
                }
            }
        }
        //将堆中的元素依次取出放入ret并返回
        int i = 0;
        while(!queue.isEmpty()){
            ret[i++] = queue.poll().val;
        }
        return ret;
    }
}


//不用Map解决
//public class Num347_TopKFrequent {
//    public int[] topKFrequent(int[] nums, int k) {
//        int[] ret = new int[k];
//        Arrays.sort(nums);
//        int i = 0;
//        int count = 0;
//        List<Node> node = new ArrayList<>();
//        for (int j = 0; j < nums.length; j++) {
//            if(nums[i] == nums[j]){
//                count++;
//            }else{
//                node.add(new Node(nums[i], count));
//                count = 1;
//                i = j;
//            }
//            if(j == nums.length - 1){
//                node.add(new Node(nums[j], count));
//            }
//        }
//
//        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.occ - o2.occ;
//            }
//        });
//
//        for (int j = 0; j <node.size(); j++) {
//            if(queue.size() < k){
//                queue.offer(node.get(j));
//            }else{
//                if(node.get(j).occ > queue.peek().occ){
//                    queue.poll();
//                    queue.offer(node.get(j));
//                }
//            }
//        }
//        int j = 0;
//        while(!queue.isEmpty()){
//            ret[j++] = queue.poll().val;
//        }
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,2,3,1,2,3,3,4};
//        Num347_TopKFrequent test = new Num347_TopKFrequent();
//        int[] ret = test.topKFrequent(arr, 3);
//        System.out.println(Arrays.toString(ret));
//    }
//}
