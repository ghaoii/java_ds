package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num94_InorderTraversal {
    private List<Integer> ret = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return ret;
        }
        inorderTraversal(root.left);
        ret.add(root.val);
        inorderTraversal(root.right);
        return ret;
    }
}
