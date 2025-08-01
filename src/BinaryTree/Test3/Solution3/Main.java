package BinaryTree.Test3.Solution3;

import BinaryTree.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 使用迭代实现层序遍历来翻转二叉树
 */

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {4,2,7,1,3,6,9};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        solution.invertTree(root);
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            // 翻转
            if(node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left != null) {
                list.offer(node.left);
            }
            if(node.right != null) {
                list.offer(node.right);
            }
        }
        return root;
    }
}