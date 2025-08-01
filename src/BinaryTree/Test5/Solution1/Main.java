package BinaryTree.Test5.Solution1;

import BinaryTree.Common.TreeNode;

/**
 * 递归求二叉树最大深度
 */

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
        return digSeek(root, 0);
    }

    public int digSeek(TreeNode node, int depth) {
        if(node == null) return depth;
        int left = 0;
        int right = 0;
        if(node.left != null) {
            left = digSeek(node.left, depth + 1);
        }
        if(node.right != null) {
            right = digSeek(node.right, depth + 1);
        }
        return max(max(left, right), depth+1);
    }
}