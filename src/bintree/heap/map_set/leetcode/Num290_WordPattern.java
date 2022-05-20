package bintree.heap.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)){
                //如果没有包含该字符，那么取出该字符所对应的数字
                map.put(ch, count);
                count++;
            }
            sb.append(map.get(ch));
        }
        //走完循环之后sb中的字符串就是相应的规律了，接下里处理s
        String[] str = s.split(" ");//将字符串拆分为一个个子字符串
        count = 1;
        StringBuilder sb1 = new StringBuilder();
        Map<String, Integer> map1 = new HashMap<>();
        for (String i : str) {
            if(!map1.containsKey(i)){
                map1.put(i, count);
                count++;
            }
            sb1.append(map1.get(i));
        }
        //最后比较两个字符串之间的规律是否相同即可
        return sb.toString().equals(sb1.toString());
    }
}
