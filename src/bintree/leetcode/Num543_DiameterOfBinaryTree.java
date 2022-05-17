package bintree.leetcode;

public class Num543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int diameter = height(root.left) + height(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return left > right ? Math.max(left, diameter) : Math.max(right, diameter);
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
