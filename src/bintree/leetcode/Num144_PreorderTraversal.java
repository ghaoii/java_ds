package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num144_PreorderTraversal {
    private List<Integer> arr = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return arr;
        }
        arr.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return arr;
    }
}
