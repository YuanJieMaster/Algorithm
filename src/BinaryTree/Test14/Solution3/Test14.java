package BinaryTree.Test14.Solution3;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 二叉搜索树的最小绝对差
 */

public class Test14 {
    public static void main(String[] args) {// 根据输入构建二叉树
        Integer[] input = {4,2,6,1,3}; // true
        TreeNode root = buildTree(input);

        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(root));
    }
}

class Solution {
    TreeNode pre = null;
    int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        getDifference(root);
        return diff;
    }
    public void getDifference(TreeNode node) {
        if(node.left != null) {
            getDifference(node.left);
        }
        if(pre != null) {
            diff = Math.min(diff, node.val - pre.val);
        }
        pre = node;
        if(node.right != null) {
            getDifference(node.right);
        }
    }
}