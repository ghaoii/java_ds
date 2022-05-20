package bintree;


class BinSearchNode{
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


    public void add(int val){
        root = add(root, val);
    }

    /**
     * 向当前以root为根的BST中插入一个新结点，返回插入新结点后的根结点
     * @param val
     */
    private BinSearchNode add(BinSearchNode root, int val){
        if(root == null){
            BinSearchNode node = new BinSearchNode(val);
            size++;
            return node;
        }
        if(val < root.val){
            //在左子树中插入
            root.left = add(root.left, val);
        }
        if(val > root.val){
            root.right = add(root.right, val);
        }
        return root;
    }

    public boolean contains(int val){
        return contains(root, val);
    }

    /**
     * 如果树的根结点和待查找元素val，如果找到了则返回true，否则返回false
     * @param root
     * @param val
     * @return
     */
    private boolean contains(BinSearchNode root, int val){
        if(root == null){
            return false;
        }
        if(val < root.val){
            //在左子树中寻找
            return contains(root.left, val);
        }else if(val > root.val){
            //在右子树中寻找
            return contains(root.right, val);
        }else{
            //找到了返回true
            return true;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    /**
     * 按照先序遍历的方式，将BST的节点值存入到sb之中
     * @param root
     * @param height
     * @param sb
     */
    private void generateBSTString(BinSearchNode root, int height, StringBuilder sb) {
        if(root == null){
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
