package BinaryTree.Test5.Solution3;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return max(left, right) + 1;
    }
}