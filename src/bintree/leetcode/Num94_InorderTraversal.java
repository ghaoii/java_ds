package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num94_InorderTraversal {
    //迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;//判断条件可以不写，因为不会进入循环
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }


    //递归
//    private List<Integer> ret = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null){
//            return ret;
//        }
//        inorderTraversal(root.left);
//        ret.add(root.val);
//        inorderTraversal(root.right);
//        return ret;
//    }
}
