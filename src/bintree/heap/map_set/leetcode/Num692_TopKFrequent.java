package bintree.heap.map_set.leetcode;

import java.util.*;

class WordNode{
    //保存出现过的单词
    String str;
    //保存该单词出现的次数
    int occ;

    public WordNode(String str, int occ) {
        this.str = str;
        this.occ = occ;
    }
}

/**
 * 返回出现频率最高的单词 - 取大用小
 */
public class Num692_TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        //循环遍历words，将每个单词及其出现的次数保存到Map集合中
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        //建立优先级队列，让设定比较器
        Queue<WordNode> queue = new PriorityQueue<>(new Comparator<WordNode>() {
            @Override
            public int compare(WordNode o1, WordNode o2) {
                return o1.occ - o2.occ;
            }
        });

        //遍历键值对，将出现次数最多的前K个元素放入最小堆中
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(queue.size() < k){
                //如果堆的元素个数不足k个，直接入队
                WordNode node = new WordNode(entry.getKey(), entry.getValue());
                queue.offer(node);
            }else{
                //查看当前元素是否大于堆顶元素，如果大于，则删除堆顶元素并插入当前元素
                if(entry.getValue() > queue.peek().occ){
                    queue.poll();
                    queue.offer(new WordNode(entry.getKey(), entry.getValue()));
                }
            }
        }


        //遍历输出出现频率最多的K个元素
        List<String> ret = new ArrayList<>();
        WordNode prev = null;
        while(!queue.isEmpty()){
            //考虑出现频率相同，字节序不同的问题
            //如果出现连续多个频率相同，字典顺序不同的元素时，又怎么办？
            //堆排序？
            //但是没有数组？
        }
        return ret;
    }


}
