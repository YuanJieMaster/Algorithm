package BinaryTree.Test8.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }
}

class Solution {
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        howDeep(root);
        return balance;
    }
    // 输出子树的深度
    public int howDeep(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = howDeep(root.left);
        int right = howDeep(root.right);
        if(Math.abs(left - right) > 1) {
            balance = false;
        }
        return Math.max(left, right) + 1;
    }
}