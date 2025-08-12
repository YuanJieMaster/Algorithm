package BinaryTree.Test16.Solution2;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 二叉树的最近公共祖先
 * 普通的暴力解法
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
    boolean find = false;
    TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        countTraversal(root, p, q);
        return node;
    }

    public int countTraversal(TreeNode root, TreeNode p, TreeNode q) {
        if(find) return 0;
        if(root == null) return 0;
        int count = countTraversal(root.left, p, q) + countTraversal(root.right, p, q) + ((root == q || root == p)?1:0);
        if(!find && count == 2) {
            node = root;
            find = true;
        }
        return count;
    }
}