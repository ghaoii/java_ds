package jcl.hash.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num219_ContainsNearbyDuplicate {
    //Map
    Map<Integer, Integer> map =new HashMap<>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k ){
                //如果当前元素以及出现过，且范围在k之内，则返回true
                return true;
            }
            //如果该元素没有出现，存入map
            //如果已经出现过，则将索引更新为当前索引，
            map.put(nums[i], i);
        }
        return false;
    }


    //暴力解
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
//                if(Math.abs(nums[i] - nums[j]) == 0){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
