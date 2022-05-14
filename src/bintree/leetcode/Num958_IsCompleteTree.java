package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num958_IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean secondStep = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!secondStep){
                if(node.left != null && node.right != null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else if(node.left != null){
                    queue.offer(node.left);
                    secondStep = true;
                }else if(node.right != null){
                    return false;
                }else{
                    secondStep = true;
                }
            }else{
                if(node.left != null || node.right != null){
                    return false;
                }
            }
        }
        return true;
    }
}
