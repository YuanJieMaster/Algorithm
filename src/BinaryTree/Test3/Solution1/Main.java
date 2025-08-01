package BinaryTree.Test3.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {4,2,7,1,3,6,9};
        TreeNode root = buildTree(input);
        BinaryTree.Test3.Solution1.Solution solution = new BinaryTree.Test3.Solution1.Solution();
        solution.invertTree(root);
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        if(root.left != null) {
            invertTree(root.left);
        }
        if(root.right != null) {
            invertTree(root.right);
        }
        return root;
    }
}