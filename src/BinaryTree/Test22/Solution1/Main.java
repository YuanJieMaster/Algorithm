package BinaryTree.Test22.Solution1;


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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int sum = 0;
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if(node == null) {
                node = st.pop();
                sum += node.val;
                node.val = sum;
                continue;
            };
            if(node.left != null) {
                st.push(node.left);
            }
            st.push(node);
            st.push(null);
            if(node.right != null) {
                st.push(node.right);
            }
        }
        return root;
    }
}