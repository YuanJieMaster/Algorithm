package BinaryTree.Test18.Solution2;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        Integer[] input = {4,2,7,1,3};
        TreeNode root = buildTree(input);
        int val = 5;
        Solution solution = new Solution();
        System.out.println(solution.insertIntoBST(root, val));
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}