package BinaryTree.Test22.Solution2;


import BinaryTree.Common.TreeNode;

import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 把二叉搜索树转换为类累加树-迭代
 */

public class Main {
    public static void main(String[] args) {
        Integer[] input = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.convertBST(root));
    }
}

class Solution {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        root.val += pre;
        pre = root.val;
        convertBST(root.left);
        return root;
    }
}