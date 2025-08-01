package BinaryTree.Test9.Solution3;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
//        Integer[] input = {1,2,2,null,3,null,3,null,null,4};
        Integer[] input = {1,2,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(root));
    }
}

class Solution {
    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return paths;
        }
        binaryTreePath(root, new StringBuilder());
        return paths;
    }

    public void binaryTreePath(TreeNode node, StringBuilder prePath) {
        int length = prePath.length();
        if(prePath.isEmpty()) {
            prePath.append(String.valueOf(node.val));
        } else {
            prePath.append("->" + String.valueOf(node.val));
        }
        if(node.left == null && node.right == null) {
            paths.add(prePath.toString());
        }
        if(node.left != null) {
            binaryTreePath(node.left, prePath);
        }
        if(node.right != null) {
            binaryTreePath(node.right, prePath);
        }
        prePath.setLength(length);
    }
}