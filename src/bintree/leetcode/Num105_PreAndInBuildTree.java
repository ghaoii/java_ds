package bintree.leetcode;

public class Num105_PreAndInBuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    //每次从前序遍历中取出树根，通过树根在中序遍历中的位置来构建二叉树，返回树根
    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if(index >= preorder.length){
            return null;
        }
        if(left > right){
            return null;
        }
        int pos = findPos(inorder, preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, inorder, left, pos - 1);
        root.right = build(preorder, inorder, pos + 1, right);
        return root;
    }

    private int findPos(int[] inorder, int num) {
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == num){
                return i;
            }
        }
        return -1;
    }
}
