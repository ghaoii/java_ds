package bintree.heap.map_set.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num136_SingleNumber {
    //异或解法
//    public int singleNumber(int[] nums) {
//        int ret = 0;
//        for(int i : nums){
//            ret ^= i;
//        }
//        return ret;
//    }


    //Map解法
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组，将各元素值出现的次数存入map中
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        //遍历map，取出只出现了一次的元素，并返回其元素值
        int ret = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                ret = entry.getKey();
            }
        }
        return ret;
    }
}
