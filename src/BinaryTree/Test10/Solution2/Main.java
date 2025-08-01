package BinaryTree.Test10.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3,null,null,4};
//        Integer[] input = {1,2,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            if(node == null) {
                node = list.poll();
                if(node.left == null && node.right == null) {
                    res += node.val;
                    continue;
                }
            }

            if(node.left != null) {
                list.offer(null);
                list.offer(node.left);
            }
            if(node.right != null) {
                list.offer(node.right);
            }
        }
        return res;
    }
}