package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num145_PostorderTraversal {
    private List<Integer> ret = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return ret;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ret.add(root.val);
        return ret;
    }
}
