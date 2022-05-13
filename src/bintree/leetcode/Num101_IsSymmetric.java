package bintree.leetcode;

public class Num101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}
