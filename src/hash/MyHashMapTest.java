package hash;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(4);
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        //System.out.println(map.add(2, 200));
        map.put(6, 60);
        System.out.println(map.remove(2, 20));
        //System.out.println(map.remove(3, 300));

//        System.out.println(map.contains(2, 20));
//        System.out.println(map.contains(3, 300));
        System.out.println();
    }
}
