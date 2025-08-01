package BinaryTree.Test12.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {4,2,7,1,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.searchBST(root, 2));
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) return searchBST(root.left, val);
        if(root.val < val) return searchBST(root.right, val);
        return null;
    }
}