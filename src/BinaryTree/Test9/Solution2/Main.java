package BinaryTree.Test9.Solution2;

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
        binaryTreePath(root, new ArrayList<String>());
        return paths;
    }

    public void binaryTreePath(TreeNode node, List<String> prePath) {
        prePath.add(String.valueOf(node.val));
        if(node.left == null && node.right == null) {
            paths.add(String.join("->", prePath));
            return;
        }
        if(node.left != null) {
            binaryTreePath(node.left, prePath);
            prePath.removeLast();
        }
        if(node.right != null) {
            binaryTreePath(node.right, prePath);
            prePath.removeLast();
        }
    }
}