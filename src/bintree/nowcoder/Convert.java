package bintree.nowcoder;

public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        //将左子树交给子方法处理后，返回链表的头结点
        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode leftTail = leftHead;
        while(leftTail != null && leftTail.right != null){
            //找到左链表的末尾结点
            leftTail = leftTail.right;
        }
        //将左链表和根结点进行连接
        if(leftTail != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //将右子树转化为链表，返回头结点
        TreeNode rightHead = Convert(pRootOfTree.right);
        if(rightHead != null){
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        return leftHead == null ? pRootOfTree : leftHead;
    }
}
