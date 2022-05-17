package bintree.leetcode;

public class Num106_InAndPostBuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        reverse(postorder);
        return build(inorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] revOrder, int left, int right){
        if(index >= revOrder.length){
            return null;
        }
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(revOrder[index]);
        index++;
        int pos = find(inorder, root.val);
        root.right = build(inorder, revOrder, pos + 1, right);
        root.left = build(inorder, revOrder, left, pos - 1);
        return root;
    }

    private int find(int[] inorder, int val){
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }

    private void reverse(int[] postorder){
        int left = 0;
        int right = postorder.length - 1;
        while(left < right){
            int tmp = postorder[left];
            postorder[left] = postorder[right];
            postorder[right] = tmp;
            left++;
            right--;
        }
    }
}
