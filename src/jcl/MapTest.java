package jcl;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("及时雨");
        set.add("智多星");
        set.add("豹子头");
        System.out.println(set);//HashSet和TreeMap的输出(存储)顺序也是不同的

//        Map<String, String> map = new TreeMap<>();
//        try{
//            map.put(null, null);
//        }catch (NullPointerException e){
//            System.out.println("key为空");
//        }
//        map.put("test", null);
//        System.out.println(map.toString());


//        Map<Node, String> map = new TreeMap<>();
//        map.put(new Node(), "test");

//        Map<String, String> map = new TreeMap<>();
//        map.put("及时雨", "宋江");
//        map.put("智多星", "吴用");
//        map.put("九纹龙", "史进");
//        map.put("豹子头", "林冲");
//        System.out.println(map.toString());


//        System.out.println(map.put("智多星", "张三"));// 20 返回修改前的值
//        Set<String> keys = map.keySet();
//        for(String str : keys){
//            System.out.print(str + " ");// 智多星 豹子头 及时雨 九纹龙
//        }
//        System.out.println();
//        Collection<String> values = map.values();
//        for(String i : values){
//            System.out.print(i + " ");// 张三 林冲 宋江 史进
//        }

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
//        map.put(3, 30);
//        map.put(4, 40);
//        System.out.println(map.put(2, 200));// 20 返回修改前的值
//        Set<Integer> keys = map.keySet();
//        for(Integer i : keys){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        Collection<Integer> values = map.values();
//        for(Integer i : values){
//            System.out.print(i + " ");
//        }
    }

//    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1,10);
//        map.put(2,20);
//        //value可以重复，但是key不能，一个key只会得到一个对应的value
//        map.put(3,10);
//        System.out.println(map.containsKey(3));
//        System.out.println(map.containsValue(40));
//        //Map.Entry[]
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }
//    }
}
