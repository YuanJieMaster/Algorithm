package BinaryTree.Test20.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 修剪二叉搜索树
 * 迭代
 */

public class Main {
    public static void main(String[] args) {
        Integer[] input = {3,0,4,null,2,null,null,1};
        TreeNode root = buildTree(input);
        int low = 1;
        int high = 3;
        Solution solution = new Solution();
        System.out.println(solution.trimBST(root, low, high));
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 到达区间内
        while(root != null && (root.val < low || root.val > high)) {
            if(root.val < low) {
                root = root.right;
            }
            if(root.val > high) {
                root = root.left;
            }
        }
        if(root == null) return null;
        // 处理左子树
        TreeNode cur = root;
        while(cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        // 处理右子树
        cur = root;
        while(cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}