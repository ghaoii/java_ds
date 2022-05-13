package bintree;

class TreeNode<E> {
    E val;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E val){
        this.val = val;
    }
}


public class MyBinTree<E> {
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

    /**
     * 传入一个二叉树的根结点，就能返回该二叉树的结点个数
     * @param root
     * @return
     */
    public int getNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + getNodes(root.left) + getNodes(root.right);
        //可以简化为一句话
        //return root == null ? 0 : 1 + getNodes(root.left) + getNodes(root.right);
    }

    /**
     * 传入一个二叉树的根结点，就能返回该二叉树的结点个数
     * @param root
     * @return
     */
    public int getLeafNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodes(root.left) + getLeafNodes(root.right);
    }

    /**
     * 传入一个二叉树的根结点和层数K，就能返回该二叉树第K层的结点个数
     * @param root
     * @return
     */
    public int getKLevelNodes(TreeNode root, int k){
        if(k < 1 || root == null){
            return 0;
        }
        if(k == 1){
            //当k为1时，说明只有根结点这一层，因此直接返回1即可
            return 1;
        }
        //此时k不为1，就继续找下一层
        return getKLevelNodes(root.left, k - 1) + getKLevelNodes(root.right, k - 1);
    }

    /**
     * 传入一个二叉树的根结点，就能返回该二叉树的高度
     * @param root
     * @return
     */
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        //树的高度 = 当前层 + 子树中的高度
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * 传入一个二叉树的根结点和值val，就能判断出二叉树中是否包含val
     * @param root
     * @param val
     * @return
     */
    public boolean contains(TreeNode<E> root, E val){
        if(root == null){
            return false;
        }
        if(root.val.equals(val)){
            return true;
        }
        return contains(root.left, val) || contains(root.right, val);
    }
}
