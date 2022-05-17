package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num530_GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        int min = (int) Math.pow(10, 5);
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null) {
                int dif = cur.val - prev.val;
                min = Math.min(min, dif);
            }
            prev = cur;
            cur = cur.right;
        }
        return min;
    }
}
