package BinaryTree.Test7.Solution2;

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
        list.add(root);
        int n = 0;
        while(true) {
            TreeNode node = list.get(n++);
            if(node.left == null) {
                return list.size();
            }
            list.add(node.left);
            if(node.right == null) {
                return list.size();
            }
            list.add(node.right);
        }
    }
}
