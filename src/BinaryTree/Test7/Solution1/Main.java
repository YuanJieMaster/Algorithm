package BinaryTree.Test7.Solution1;

import BinaryTree.Common.TreeNode;

import java.util.LinkedList;

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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int n = 1;
        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            if(node.left == null) {
                return n;
            }
            list.offer(node.left);
            n++;
            if(node.right == null) {
                return n;
            }
            list.offer(node.right);
            n++;
        }
        return n;
    }
}
