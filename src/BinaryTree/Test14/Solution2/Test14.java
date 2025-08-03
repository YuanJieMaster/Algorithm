package BinaryTree.Test14.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 二叉搜索树的最小绝对差
 */

public class Test14 {
    public static void main(String[] args) {// 根据输入构建二叉树
//        Integer[] input = {4,2,6,1,3}; // true
        Integer[] input = {543,384,652,null,445,null,699}; // true
        TreeNode root = buildTree(input);

        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(root));
    }
}

class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int diff = Integer.MAX_VALUE;
        Integer pre = null;
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if(node == null) {
                node = st.pop();
                if(pre == null) {
                    pre = node.val;
                } else {
                    diff = Math.min(diff, node.val - pre);
                    pre = node.val;
                }
                continue;
            }
            if(node.right != null) {
                st.push(node.right);
            }
            st.push(node);
            st.push(null);
            if(node.left != null) {
                st.push(node.left);
            }
        }
        return diff;
    }
}