package BinaryTree.Test14.Solution1;

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
    public int getMinimumDifference(TreeNode root) {
        int diff = Integer.MAX_VALUE;
        int left_diff = Integer.MAX_VALUE;
        int right_diff = Integer.MAX_VALUE;
        TreeNode cur;
        // 求与左子树最小差值
        if(root.left != null) {
            cur = root.left;
            while(cur.right != null) {
                cur = cur.right;
            }
            diff = Math.min(diff, Math.abs(root.val - cur.val));
        }

        // 求与右子树最小差值
        if(root.right != null) {
            cur = root.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            diff = Math.min(diff, Math.abs(root.val - cur.val));
        }

        // 同求左子树和右子树
        if(root.left != null) {
            left_diff = getMinimumDifference(root.left);
        }
        if(root.right != null) {
            right_diff = getMinimumDifference(root.right);
        }

        // 返回
        return Math.min(diff, Math.min(left_diff, right_diff));
    }
}