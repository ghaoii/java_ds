package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num103_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 1;
        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                arr.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            if(height % 2 == 0){
                reverse(arr);
            }
            height++;
            ret.add(arr);
        }
        return ret;
    }

    private void reverse(List<Integer> arr){
        int left = 0;
        int right = arr.size() - 1;
        while(left < right){
            int tmp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, tmp);
            left++;
            right--;
        }
    }
}
