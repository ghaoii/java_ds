package jcl;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.contains(2));
        System.out.println(set.contains(4));
        System.out.println(set.remove(1));
        for(int i : set){
            System.out.print(i + " ");
        }
    }
}
