package bintree.leetcode;

public class Num236_LCA {
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p , q);
        return lca;
    }

    /**
     * 方法的语义：传入根结点，就能判断根结点都是否至少存在一个p或q，找到其中一个就返回true
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2){
            lca = root;
        }
        return (left + right + mid ) > 0;
    }
}
