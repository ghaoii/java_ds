package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num662_WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        queue.offer(root);
        deque.offer(0);
        int max = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int weight = deque.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                    deque.offer(weight * 2 + 1);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    deque.offer(weight * 2 + 2);
                }
            }
            //比较宽度
            if(!deque.isEmpty()){
                max = Math.max(max, deque.peekLast() - deque.peekFirst() + 1);
            }
        }
        return max;
    }
}
