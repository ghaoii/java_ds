package bintree.leetcode;

public class Num111_MinDepth {
    /**
     * 传入一棵树的根结点，就能得到这颗树的最小深度，并返回最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
