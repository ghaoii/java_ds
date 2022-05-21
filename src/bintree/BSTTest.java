package bintree;

import com.sun.media.sound.SF2Instrument;

public class BSTTest {
    public static void main(String[] args) {
        MyBinSearchTree binSearchTree = new MyBinSearchTree();
        binSearchTree.add(22);
        binSearchTree.add(15);
        binSearchTree.add(28);
        binSearchTree.add(11);
        binSearchTree.add(17);
        binSearchTree.add(25);
        binSearchTree.add(12);
//        System.out.println(binSearchTree.findMin());
//        System.out.println(binSearchTree.findMax());

        binSearchTree.remove(15);
        System.out.println(binSearchTree);
    }
}
