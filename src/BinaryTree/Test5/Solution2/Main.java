package BinaryTree.Test5.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int n = 0;
        while(!list.isEmpty()) {
            int size = list.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    list.offer(node.left);
                }
                if (node.right != null) {
                    list.offer(node.right);
                }
            }
            n++;
        }
        return n;
    }
}