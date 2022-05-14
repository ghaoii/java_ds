package bintree;

public class TreeTest {
    //使用迭代方法的二叉树
    public static void main(String[] args) {
        MyBinTree<TreeNode<Character>> binTree = new MyBinTree<>();
        binTree.build();
        System.out.print("层序遍历的结果是：");
        binTree.levelOrder(binTree.root);
        System.out.println();
        System.out.println("二叉树的结点个数是：" + binTree.getNodesNonRecursion(binTree.root));
        System.out.println("二叉树的叶子结点的个数为：" + binTree.getLeafNodesNonRecursion(binTree.root));
        System.out.println("二叉树的第四层的结点个数是：" + binTree.getKLevelNodesNonRecursion(binTree.root, 4));
        System.out.println("二叉树的高度是：" + binTree.heightNonRecursion(binTree.root));
    }


    //使用递归方法的二叉树
//    public static void main(String[] args) {
//        MyBinTree binTree = new MyBinTree();
//        binTree.build();
//        System.out.print("前序遍历的结果为：");
//        binTree.preOrder(binTree.root);
//        System.out.println();
//        System.out.print("中序遍历的结果为：");
//        binTree.inOrder(binTree.root);
//        System.out.println();
//        System.out.print("后序遍历的结果为：");
//        binTree.postOrder(binTree.root);
//        System.out.println();
//        System.out.println("根结点的个数是" + binTree.getNodes(binTree.root));
//        System.out.println("叶子结点的个数是" + binTree.getLeafNodes(binTree.root));
//        System.out.println("第四层的结点的个数是" + binTree.getKLevelNodes(binTree.root, 4));
//        System.out.println("二叉树的高度是" + binTree.height(binTree.root));
//        System.out.println(binTree.contains(binTree.root, 'G'));
//    }
}
