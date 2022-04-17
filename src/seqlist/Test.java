package seqlist;

import seqlist.MyArray;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(3);
        myArray.add(10);
        myArray.add(10);
        myArray.add(20);
        myArray.add(40);
        System.out.println(myArray.removeByValAll(10));
        System.out.println(myArray);
    }
}
