package bintree.leetcode;

public class Num110_IsBalanced {

    //写法二
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int tmp = Math.abs(left - right);
        return tmp <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //写法一
//    public boolean isBalanced(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1){
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
