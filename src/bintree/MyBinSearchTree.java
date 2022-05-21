package bintree;


import java.beans.BeanInfo;
import java.util.NoSuchElementException;

class BinSearchNode {
    int val;
    BinSearchNode left;
    BinSearchNode right;

    public BinSearchNode(int val) {
        this.val = val;
    }
}

/**
 * 基于整型的二分搜索树
 */
public class MyBinSearchTree {
    private int size;
    private BinSearchNode root;


    public void add(int val) {
        root = add(root, val);
    }

    /**
     * 向当前以root为根的BST中插入一个新结点，返回插入新结点后的根结点
     *
     * @param val
     */
    private BinSearchNode add(BinSearchNode root, int val) {
        if (root == null) {
            BinSearchNode node = new BinSearchNode(val);
            size++;
            return node;
        }
        if (val < root.val) {
            //在左子树中插入
            root.left = add(root.left, val);
        }
        if (val > root.val) {
            root.right = add(root.right, val);
        }
        return root;
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    /**
     * 如果树的根结点和待查找元素val，如果找到了则返回true，否则返回false
     *
     * @param root
     * @param val
     * @return
     */
    private boolean contains(BinSearchNode root, int val) {
        if (root == null) {
            return false;
        }
        if (val < root.val) {
            //在左子树中寻找
            return contains(root.left, val);
        } else if (val > root.val) {
            //在右子树中寻找
            return contains(root.right, val);
        } else {
            //找到了返回true
            return true;
        }
    }

    public int findMin() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty! cannot search!");
        }
        return min(root).val;
    }

    /**
     * 传入根结点，就能找到该BST中的最小结点，并返回其位置
     *
     * @param root
     * @return
     */
    private BinSearchNode min(BinSearchNode root) {
        if (root.left == null) {
            //当根结点没有左子树的时候，那么根结点就是最小值
            return root;
        }
        return min(root.left);
    }

    public int findMax() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty! cannot search");
        }
        return max(root).val;
    }

    private BinSearchNode max(BinSearchNode root) {
        if (root.right == null) {
            //当根结点没有右子树的时候，根结点就是最大值
            return root;
        }
        return max(root.right);
    }

    public int removeMin() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty! cannot remove!");
        }
        BinSearchNode ret = min(root);
        root = removeMin(root);
        return ret.val;
    }

    /**
     * 传入根结点，就能删除BST中的最小值，并返回删除结点后的根结点
     *
     * @param root
     * @return
     */
    private BinSearchNode removeMin(BinSearchNode root) {
        if (root.left == null) {
            //如果左子树为空，说明当前根结点就是最小值，即待删除元素
            BinSearchNode right = root.right;
            root.left = root.right = root = null;
            size--;
            return right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public int removeMax() {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty! cannot remove");
        }
        BinSearchNode ret = max(root);
        root = removeMax(root);
        return ret.val;
    }

    /**
     * 传入树根结点，删除该BST中的最大值，并返回删除后的树根结点
     *
     * @param root
     * @return
     */
    private BinSearchNode removeMax(BinSearchNode root) {
        if (root.right == null) {
            //当右子树为空的时候，说明根结点就是最大值
            BinSearchNode left = root.left;
            root.left = root.right = root = null;
            size--;
            return left;//将左结点作为新的根结点返回
        }
        root.right = removeMax(root.right);
        return root;
    }


    public void remove(int val) {
        if (size == 0) {
            throw new NoSuchElementException("BST is empty! cannot remove!");
        }
        root = remove(root, val);
    }

    /**
     * 传入树根结点和待删除元素val，返回删除val后的树根结点
     * @param root
     * @param val
     * @return
     */
    private BinSearchNode remove(BinSearchNode root, int val) {
        if (root == null) {
            //这里并不是传入了一个空结点，而是整个BST已经遍历完，但是还没有找到val，说明val不存在
            throw new NoSuchElementException("val dose not exist! cannot remove");
        }
        if (root.val == val) {
            if(root.left == null){
                //类似删除最小值
                BinSearchNode right = root.right;
                root.right = root = null;
                size--;
                return right;
            }
            if(root.right == null){
                //类似删除最大值
                BinSearchNode left = root.left;
                root.left = root = null;
                size--;
                return left;
            }
            //根结点就是待删除元素，左右子树都存在，则找到前驱或者后继
            BinSearchNode next = min(root.right);
            next.right = removeMin(root.right);
            next.left = root.left;
            root.left = root.right = root = null;
            return next;
        }
        if (val < root.val) {
            root.left = remove(root.left, val);
            return root;
        }
        root.right = remove(root.right, val);
        return root;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    /**
     * 按照先序遍历的方式，将BST的节点值存入到sb之中
     *
     * @param root
     * @param height
     * @param sb
     */
    private void generateBSTString(BinSearchNode root, int height, StringBuilder sb) {
        if (root == null) {
            sb.append(generateHeightStr(height)).append("NULL\n");
            return;
        }
        //打印当前根结点的高度和元素值
        sb.append(generateHeightStr(height)).append(root.val).append("\n");
        //构建左子树
        generateBSTString(root.left, height + 1, sb);
        //构建右子树
        generateBSTString(root.right, height + 1, sb);
    }

    //按照当前的高度打印--
    private String generateHeightStr(int height) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
