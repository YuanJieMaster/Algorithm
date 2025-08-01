package BinaryTree.Test2.Solution1;

import BinaryTree.Common.TreeNode;

import java.util.*;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        for(List<Integer> list: lists) {
            for(Integer value: list) {
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            int size = list.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                layer.add(node.val);
                if(node.left != null) {
                    list.offer(node.left);
                }
                if(node.right != null) {
                    list.offer(node.right);
                }
            }
            res.add(layer);
        }
        return res.reversed();
    }
}