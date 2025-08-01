package BinaryTree.Test8.Solution3;

import BinaryTree.Common.TreeNode;

import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3,null,null,4};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        initVal(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();

            boolean leftSeeked = node.left == null || node.left.val != -1;
            boolean rightSeeked = node.right == null || node.right.val != -1;

            if(leftSeeked && rightSeeked) {
                int left = node.left == null? 0:node.left.val;
                int right = node.right == null? 0:node.right.val;
                if(Math.abs(left-right) > 1) {
                    return false;
                }
                node.val = Math.max(left, right) + 1;
                continue;
            }

            st.push(node);
            if(node.right != null) {
                st.push(node.right);
            }
            if(node.left != null) {
                st.push(node.left);
            }
        }
        return true;
    }

    public void initVal(TreeNode node) {
        if(node == null) {
            return;
        }
        node.val = -1;
        initVal(node.left);
        initVal(node.right);
    }
}