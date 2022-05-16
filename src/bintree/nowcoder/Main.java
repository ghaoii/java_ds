package bintree.nowcoder;

import java.util.Scanner;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class Main {
    private static int index = 0;

    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            TreeNode root = build(str);
            inOrder(root);
            System.out.println();
            index = 0;
        }
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static TreeNode build(String str) {
        if(index == str.length()){
            return null;
        }
        char ch = str.charAt(index);
        if(ch == '#'){
            return null;
        }
        TreeNode root = new TreeNode(ch);
        index++;
        root.left = build(str);
        index++;
        root.right = build(str);
        return root;
    }
}
