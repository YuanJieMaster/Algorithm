package BinaryTree.Test7.Solution3;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {1,2,2,3,4,4,3};
//        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.countNodes(root));
    }
}


class Solution {
    int n = 0;
    public int countNodes(TreeNode root) {
        if(root == null) {
            return n;
        }
        n++;
        countNodes(root.left);
        countNodes(root.right);
        return n;
    }
}
