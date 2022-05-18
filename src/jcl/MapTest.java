package jcl;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        //value可以重复，但是key不能，一个key只会得到一个对应的value
        map.put(3,10);
        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue(40));
        //Map.Entry[]
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}
