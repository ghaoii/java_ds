package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num700_SearchBST {
    //迭代
    public TreeNode searchBST(TreeNode root, int val) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val == val){
                return cur;
            }
            cur = cur.right;
        }
        return null;
    }


    //递归
//    public TreeNode searchBST(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//        if(val < root.val){
//            return searchBST(root.left, val);
//        }
//        if(val > root.val){
//            return searchBST(root.right, val);
//        }
//        return root;
//    }
}
