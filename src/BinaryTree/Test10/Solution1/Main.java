package BinaryTree.Test10.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3,null,null,4};
//        Integer[] input = {1,2,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}

class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }
            sumOfLeftLeaves(root.left);
        }
        if(root.right != null) {
            sumOfLeftLeaves(root.right);
        }
        return res;
    }
}