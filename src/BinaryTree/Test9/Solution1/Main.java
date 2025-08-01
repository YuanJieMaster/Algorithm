package BinaryTree.Test9.Solution1;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3,null,null,4};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(root));
    }
}

class Solution {
    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePath(root, "");
        return paths;
    }

    public void binaryTreePath(TreeNode node, String prePath) {
        String s = String.valueOf(node.val);
        if(prePath.isEmpty()) {
            prePath = s;
        } else {
            prePath = prePath + "->" + s;
        }
        if(node.left == null && node.right == null) {
            paths.add(prePath);
            return;
        }
        if(node.left != null) {
            binaryTreePath(node.left, prePath);
        }
        if(node.right != null) {
            binaryTreePath(node.right, prePath);
        }
    }
}