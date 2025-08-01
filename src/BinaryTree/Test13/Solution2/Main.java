package BinaryTree.Test13.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {2,1,3}; // true
//        Integer[] input = {5,1,4,null,null,3,6}; // false
//        Integer[] input = {5,4,6,null,null,3,7}; // false
//        Integer[] input = {2147483647,2147483647}; // false
        Integer[] input = {3,2,null,1,-2147483648}; // false
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if(node == null) {
                node = st.pop();
                list.add(node.val);
                continue;
            }
            if(node.right != null) {
                st.push(node.right);
            }
            st.push(node);
            st.push(null);
            if(node.left != null) {
                st.push(node.left);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }
}