package BinaryTree.Test13.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {2,1,3}; // true
//        Integer[] input = {5,1,4,null,null,3,6}; // false
//        Integer[] input = {5,4,6,null,null,3,7}; // false
//        Integer[] input = {2147483647,2147483647}; // false
        Integer[] input = {3,2,null,1,-2147483648}; // false
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}

class Solution {
    boolean appearMin = false;
    boolean appearMax = false;
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidNode(TreeNode root, int min, int max) {
        if(root == null) return true;
        if((root.val <= min) || (root.val >= max)) {
            if(root.val == Integer.MIN_VALUE) {
                if(appearMin || root.left != null || root.val < min) {
                    return false;
                }
                appearMin = true;
            } else if (root.val == Integer.MAX_VALUE) {
                if(appearMax || root.right != null || root.val > max) {
                    return false;
                }
                appearMax = true;
            } else {
                return false;
            }
        }
        if(!isValidNode(root.left, min, root.val)) return false;
        return isValidNode(root.right, root.val, max);
    }
}