package bintree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num107_LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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
            ret.add(arr);
        }
        //逆置ret
        int left = 0;
        int right = ret.size() - 1;
        while(left < right){
            List<Integer> tmp = ret.get(left);
            ret.set(left, ret.get(right));
            ret.set(right, tmp);
            left++;
            right--;
        }
        return ret;
    }
}
