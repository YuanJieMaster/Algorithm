package BinaryTree.Test13.Solution3;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {2,1,3}; // true
//        Integer[] input = {5,1,4,null,null,3,6}; // false
//        Integer[] input = {5,4,6,null,null,3,7}; // false
//        Integer[] input = {2147483647,2147483647}; // false
//        Integer[] input = {3,2,null,1,-2147483648}; // false
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        Integer pre = null;
        Integer cur = null;
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if(node == null) {
                node = st.pop();
                cur = node.val;
                if(pre != null && cur <= pre) return false;
                pre = node.val;
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
        return true;
    }
}