package BinaryTree.Test8.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.HashMap;
import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3};
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
        HashMap<TreeNode, Integer> map = new HashMap<>();
        while(!st.isEmpty()) {
            TreeNode node = st.pop();

            boolean leftSeeked = node.left == null || map.containsKey(node.left);
            boolean rightSeeked = node.right == null || map.containsKey(node.right);

            if(leftSeeked && rightSeeked) {
                int left = node.left == null? 0:map.get(node.left);
                int right = node.right == null? 0:map.get(node.right);
                if(Math.abs(left-right) > 1) {
                    return false;
                }
                map.put(node, Math.max(left, right) + 1);
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
}