package BinaryTree.Test4.Solution3;

import BinaryTree.Common.TreeNode;

import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 用将二叉树翻转，然后采用前序遍历对比结果，在遍历的每次中都比较
 */

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {1,2,2,3,4,4,3};
//        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        st2.push(root);
        while(!(st1.isEmpty() && st2.isEmpty())) {
            TreeNode node1 = st1.pop();
            TreeNode node2 = st2.pop();
            if(node1.val != node2.val) {
                return false;
            }
            if(node1.left != null && node2.right != null) {
                st1.push(node1.left);
                st2.push(node2.right);
            } else if (!(node1.left == null && node2.right == null)) {
                return false;
            }
            if(node1.right != null && node2.left != null) {
                st1.push(node1.right);
                st2.push(node2.left);
            } else if (!(node1.right == null && node2.left == null)) {
                return false;
            }
        }
        return true;
    }
}