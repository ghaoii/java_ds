package bintree.leetcode;

import java.util.LinkedList;

public class Num1028_RecoverFromPreorder {
    private int index = 0;//用于遍历结果集
    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal, 0);
    }

    /**
     * 传入先序遍历的结果集和高度，就能构建好该层的结点，并返回构建好的根结点
     * @param str
     * @param height
     * @return
     */
    private TreeNode build(String str, int height){
        if(str == null || index == str.length()){
            //遍历的结果集为空或者所有结点已经构建完了
            return null;
        }
        int count = 0;
        for (int i = index; str.charAt(i) == '-'; i++) {
            count++;
        }
        if(count != height){
            //通过count判断下个结点的高度是否为当前结点高度
            return null;
        }
        index += count;
        int val = getNum(str);//获取元素值
        TreeNode root = new TreeNode(val);
        //将左右子树的构建交给子函数
        root.left = build(str, height + 1);
        root.right = build(str, height + 1);
        return root;
    }

    private int getNum(String str){
        int ret = 0;
        char c = str.charAt(index);
        while(c != '-'){
            ret = ret * 10 + (c - '0');
            index++;
            if(index != str.length()){
                //最后一个字符取完之后就退出循环，返回元素值
                c = str.charAt(index);
            }else{
                break;
            }
        }
        return ret;
    }
}
