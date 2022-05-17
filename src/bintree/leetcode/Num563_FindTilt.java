package bintree.leetcode;

public class Num563_FindTilt {
    //传入一棵树的根结点，就能计算出该树中每个结点的坡度之和
    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ret = slope(root);
        return ret + findTilt(root.left) + findTilt(root.right);
    }
    //传入一棵树的根结点，就能计算出给结点的坡度
    private int slope(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.abs(sum(root.left) - sum(root.right));
    }

    //传入一个根结点，就能算出该二叉树的所有结点值的和
    private int sum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
