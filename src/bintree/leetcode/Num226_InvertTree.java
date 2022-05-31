package bintree.leetcode;

public class Num226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left != null && root.right != null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            return root;
        }
        if(root.left != null){
            root.right = invertTree(root.left);
            root.left = null;
            return root;
        }
        if(root.right != null){
            root.left = invertTree(root.right);
            root.right = null;
            return root;
        }
        return root;
    }
}
