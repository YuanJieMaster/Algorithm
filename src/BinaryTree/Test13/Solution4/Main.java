package BinaryTree.Test13.Solution4;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {2,1,3}; // true
//        Integer[] input = {5,1,4,null,null,3,6}; // false
//        Integer[] input = {5,4,6,null,null,3,7}; // false
        Integer[] input = {2147483647,2147483647}; // false
//        Integer[] input = {3,2,null,1,-2147483648}; // false
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidNode(TreeNode root, Long min, Long max) {
        if(root == null) return true;
        if((root.val <= min) || (root.val >= max)) return false;
        if(!isValidNode(root.left, min, (long)root.val)) return false;
        return isValidNode(root.right, (long)root.val, max);
    }
}