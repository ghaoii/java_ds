package bintree.leetcode;

public class Num112_HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        int count = root.val;
        if(root.left == null && root.right == null){
            return count == targetSum;
        }
        return pathSum(root.left, count, targetSum) || pathSum(root.right, count, targetSum);
    }

    /**
     * 传入一棵树的根结点，以及当前路径总和，就能判断该树是否否存在存在目标路径总和
     * @param root
     * @param count
     * @param targetSum
     * @return
     */
    private boolean pathSum(TreeNode root, int count, int targetSum) {
        if(root == null){
            return false;
        }
        count += root.val;
        if(root.left == null && root.right == null){
            return count == targetSum;
        }
        return pathSum(root.left, count, targetSum) || pathSum(root.right, count, targetSum);
    }

}
