package BinaryTree.Test11.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.LinkedList;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input1 = {1,2};
        Integer[] input2 = {1,2,3};
        TreeNode root1 = buildTree(input1);
        TreeNode root2 = buildTree(input2);
        Solution solution = new Solution();
        System.out.println(solution.mergeTrees(root1, root2));
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        list1.push(root1);
        list2.push(root2);
        while(!list1.isEmpty() && !list2.isEmpty()) {
            TreeNode node1 = list1.poll();
            TreeNode node2 = list2.poll();
            node1.val += node2.val;
            if(node1.left != null && node2.left != null) {
                list1.push(node1.left);
                list2.push(node2.left);
            }
            if(node1.right != null && node2.right != null) {
                list1.push(node1.right);
                list2.push(node2.right);
            }
            if(node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if(node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}