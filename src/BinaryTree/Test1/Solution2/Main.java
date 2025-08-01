package BinaryTree.Test1.Solution2;

import BinaryTree.Common.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;
import static java.lang.Math.max;

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
        Queue<TreeNode> queue = new LinkedList<>(); // 队列
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node != null) {
                    layer.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            res.add(layer);
        }
        return res;
    }
}