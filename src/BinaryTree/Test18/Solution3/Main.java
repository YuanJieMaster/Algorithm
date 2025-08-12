package BinaryTree.Test18.Solution3;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 使用迭代
 */

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
        TreeNode par = root;
        TreeNode cur = root;
        while(cur != null) {
            if(val > cur.val) {
                par = cur;
                cur = cur.right;
            } else if(val < cur.val) {
                par = cur;
                cur = cur.left;
            }
        }
        if(val < par.val) {
            par.left = new TreeNode(val);
        }
        if(val > par.val) {
            par.right = new TreeNode(val);
        }
        return root;
    }
}