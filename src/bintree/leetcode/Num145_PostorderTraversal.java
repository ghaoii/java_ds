package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num145_PostorderTraversal {
    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.right == null || cur.right == prev){
                ret.add(cur.val);
                prev = cur;
                cur = null;
            }else{
                stack.push(cur);
                cur = cur.right;
            }
        }
        return ret;
    }

    //递归
//    private List<Integer> ret = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if(root == null){
//            return ret;
//        }
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        ret.add(root.val);
//        return ret;
//    }
}
