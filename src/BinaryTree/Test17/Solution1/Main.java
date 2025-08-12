package BinaryTree.Test17.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        Integer[] input = {6,2,8,0,4,7,9,null,null,3,5}; // true
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)) return root;
        if(lowestCommonAncestor(root.left, p, q) != null) return lowestCommonAncestor(root.left, p, q);
        if(lowestCommonAncestor(root.right, p, q) != null) return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}