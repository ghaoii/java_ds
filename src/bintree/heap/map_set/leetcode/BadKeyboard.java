package bintree.heap.map_set.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BadKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exception = null;
        String actual = null;
        while(scanner.hasNextLine()){
            exception = scanner.nextLine();
            actual = scanner.nextLine();
        }
        //将字符串都转为大写字母
        exception = exception.toUpperCase();
        actual = actual.toUpperCase();

        //将actual的值存入Set
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < actual.length(); i++) {
            set.add(actual.charAt(i));
        }
        //遍历str，将没有在actual中出现过的值输出
        Set<Character> str = new HashSet<>();
        for (int i = 0; i < exception.length(); i++) {
            char ch = exception.charAt(i);
            if(!set.contains(ch)){
                //说明该按键是坏的
                if(str.add(ch)){
                    //该按键如果没有被输出过，就进行输出
                    System.out.print(ch);
                }
            }
        }
    }
}
