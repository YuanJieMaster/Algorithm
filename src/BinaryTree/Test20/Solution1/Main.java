package BinaryTree.Test20.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 修剪二叉搜索树
 * 递归
 */

public class Main {
    public static void main(String[] args) {
        Integer[] input = {3,0,4,null,2,null,null,1};
        TreeNode root = buildTree(input);
        int low = 1;
        int high = 3;
        Solution solution = new Solution();
        System.out.println(solution.trimBST(root, low, high));
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low) {
            return trimBST(root.right, low, high);
        }
        if(root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}