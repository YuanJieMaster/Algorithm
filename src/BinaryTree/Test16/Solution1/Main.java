package BinaryTree.Test16.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 二叉树的最近公共祖先
 * 很蠢的暴力解法，会超时
 */

public class Main {
    public static void main(String[] args) {
//        Integer[] input = {4,2,6,1,3}; // true
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4}; // true
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(((root == p) && (containNodes(root, q))) || ((root == q) && (containNodes(root, p))) || (containNodes(root.left, p) && containNodes(root.right, q)) || (containNodes(root.right, p) && containNodes(root.left, q))) {
            return root;
        }
        if(containNodes(root.left, p) && containNodes(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(containNodes(root.right, p) && containNodes(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    public boolean containNodes(TreeNode root, TreeNode node) {
        if(root == null) return false;
        if(root == node) return true;
        boolean left = false;
        boolean right = false;
        if(root.left != null) {
            left = containNodes(root.left, node);
        }
        if(root.right != null) {
            right = containNodes(root.right, node);
        }
        return left || right;
    }
}