package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num144_PreorderTraversal {
    //迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ret.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return ret;
    }


    //递归
//    private List<Integer> arr = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if(root == null){
//            return arr;
//        }
//        arr.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return arr;
//    }
}
