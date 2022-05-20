package bintree.heap.map_set.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Num771_NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        //先遍历宝石，将其存放入Set集合中
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        //遍历石头，如果发现宝石就让计数器++
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if(set.contains(ch)){
                //在石头中发现宝石
                count++;
            }
        }
        return count;
    }
}
