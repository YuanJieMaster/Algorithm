package BinaryTree.Test6.Solution3;

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
    int depth = 0;
    Integer minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        digSeek(root);
        return (minDepth == Integer.MAX_VALUE)? 0: minDepth;
    }

    public void digSeek(TreeNode node) {
        depth++;
        if(node == null) {
            depth--;
            return ;
        }
        if(node.left == null && node.right == null) {
            minDepth = min(depth, minDepth);
        }
        digSeek(node.left);
        digSeek(node.right);
        depth--;
    }
}