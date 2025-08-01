package BinaryTree.Test7.Solution4;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {1,2,2,3,4,4,3};
//        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.countNodes(root));
    }
}


class Solution {
    int n = 0;
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 求左路深度
        TreeNode node = root;
        int left = 1;
        while(node.left != null) {
            node = node.left;
            left++;
        }
        int right = 1;
        while(node.right != null) {
            node = node.right;
            right++;
        }
        if(left == right) {
            return (int)Math.pow(2, left) -1;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }
}
