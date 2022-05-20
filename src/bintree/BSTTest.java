package bintree;

public class BSTTest {
    public static void main(String[] args) {
        MyBinSearchTree binSearchTree = new MyBinSearchTree();
        binSearchTree.add(22);
        binSearchTree.add(15);
        binSearchTree.add(28);
        binSearchTree.add(11);
        binSearchTree.add(17);
        binSearchTree.add(25);
        binSearchTree.add(31);
        binSearchTree.add(9);
        binSearchTree.add(12);
        binSearchTree.add(30);
        System.out.println(binSearchTree.contains(20));
        System.out.println(binSearchTree);
    }
}
