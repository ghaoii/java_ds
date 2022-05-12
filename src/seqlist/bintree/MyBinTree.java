package seqlist.bintree;

class TreeNode<E> {
    E val;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E val){
        this.val = val;
    }
}


public class MyBinTree {
    public TreeNode<Character> root;

    public void build(){
        TreeNode<Character> node = new TreeNode<>('A');
        TreeNode<Character> node1 = new TreeNode<>('B');
        TreeNode<Character> node2 = new TreeNode<>('C');
        TreeNode<Character> node3 = new TreeNode<>('D');
        TreeNode<Character> node4 = new TreeNode<>('E');
        TreeNode<Character> node5 = new TreeNode<>('F');
        TreeNode<Character> node6 = new TreeNode<>('G');
        TreeNode<Character> node7 = new TreeNode<>('H');
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node6;
        node6.right = node7;
        node2.right = node5;
        root = node;
    }

    /**
     * 传入根结点，就能按照前序遍历的方式输出 - 根左右
     * @param root
     */
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 传入根结点，就能按照中序遍历的方式输出 - 左根右
     * @param root
     */
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 传入根结点，就能根据后序遍历的方式输出 - 左右根
     * @param root
     */
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
