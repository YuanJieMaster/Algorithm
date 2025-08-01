package BinaryTree.Test6.Solution2;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        if (root.left != null) {
            left = minDepth(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = minDepth(root.right);
        }
        if (left == 0 || right == 0) {
            return max(left, right)+1;
        }
        return min(left, right)+1;
    }
}