package BinaryTree.Test19.Solution1;

import BinaryTree.Common.TreeNode;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 删除二叉搜索树中的节点
 */

public class Main {
    public static void main(String[] args) {
        Integer[] input = {5,3,6,2,4,null,7};
        TreeNode root = buildTree(input);
        int key = 3;
        Solution solution = new Solution();
        System.out.println(solution.deleteNode(root, key));
    }
}

class Solution {
    TreeNode pra;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        pra = root;
        if(root.val == key) {
            if(root.left != null) {
                TreeNode cur = root.left;
                while(cur.right != null) {
                    cur = cur.right;
                }
                root.val = cur.val;
                cur.val = key;
                root.left = deleteNode(root.left, key);
                return root;
            } else if(root.right != null) {
                TreeNode cur = root.right;
                while(cur.left != null) {
                    cur = cur.left;
                }
                root.val = cur.val;
                cur.val = key;
                root.right = deleteNode(root.right, key);
                return root;
            } else {
                return null;
            }
        }
        if(key < root.val) root.left = deleteNode(root.left, key);
        if(key > root.val) root.right = deleteNode(root.right, key);
        return root;
    }
}