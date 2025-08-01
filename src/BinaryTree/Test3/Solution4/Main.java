package BinaryTree.Test3.Solution4;

/**
 * 使用迭代前序遍历每个节点来实现翻转二叉树
 */

import BinaryTree.Common.TreeNode;

import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {4,2,7,1,3,6,9};
        TreeNode root = buildTree(input);
        BinaryTree.Test3.Solution4.Solution solution = new BinaryTree.Test3.Solution4.Solution();
        solution.invertTree(root);
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right != null) {
                st.add(node.right);
            }
            if(node.left != null) {
                st.add(node.left);
            }
            if(node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }
}