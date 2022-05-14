package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num101_IsSymmetric {
    //迭代
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            } else if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);

        }
        return true;
    }


    //递归
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        return isMirror(root.left, root.right);
//    }

//    public boolean isMirror(TreeNode p, TreeNode q){
//        if(p == null && q == null){
//            return true;
//        }
//        if(p == null || q == null){
//            return false;
//        }
//        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
//    }
}
