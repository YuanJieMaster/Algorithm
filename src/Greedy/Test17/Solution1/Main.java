package Greedy.Test17.Solution1;
import BinaryTree.Common.TreeNode;

import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        Integer[] input = {0,0,null,0,null,0,null,null,0}; // 2
        TreeNode root = buildTree(input);
        System.out.println(new Solution().minCameraCover(root));
    }
}

class Solution {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0) result++;
        return result;
    }
    public int traversal(TreeNode root) {
        if(root == null) return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);
        if(left == 2 && right == 2) {
            return 0;
        }
        if(left == 0 || right == 0) {
            result++;
            return 1;
        }
        return 2;
    }
}