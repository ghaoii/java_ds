package seqlist.bintree;

public class TreeTest {
    public static void main(String[] args) {
        MyBinTree binTree = new MyBinTree();
        binTree.build();
        System.out.print("前序遍历的结果为：");
        binTree.preOrder(binTree.root);
        System.out.println();
        System.out.print("中序遍历的结果为：");
        binTree.inOrder(binTree.root);
        System.out.println();
        System.out.print("后序遍历的结果为：");
        binTree.postOrder(binTree.root);
    }
}
