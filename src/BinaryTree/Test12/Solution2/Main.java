package BinaryTree.Test12.Solution2;

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
        while(root != null && root.val != val) {
            if (root.val > val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}