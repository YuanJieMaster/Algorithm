package BinaryTree.Test4.Solution2;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 错误示范：用将二叉树翻转，然后采用中序遍历对比结果
 * 当`root =[1,2,2,2,null,2]`的时候还是无法区分，相同值会造成干扰，那么还是得在遍历的每次中都比较才行。
 */

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
//        Integer[] input = {1,2,2,3,4,4,3};
        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> st1 = new Stack<>();
        ArrayList<Integer> res1 = new ArrayList<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            TreeNode node = st1.pop();
            if(node == null) {
                node = st1.pop();
                res1.add(node.val);
                System.out.println(node.val);
                continue;
            }
            if(node.right != null) {
                st1.push(node.right);
            }
            st1.push(node);
            st1.push(null);
            if(node.left != null) {
                st1.push(node.left);
            }
        }

        // 翻转二叉树
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) {
                st.push(node.left);
            }
            if(node.right != null) {
                st.push(node.right);
            }
        }

        Stack<TreeNode> st2 = new Stack<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        st2.push(root);
        while(!st2.isEmpty()) {
            TreeNode node = st2.pop();
            if(node == null) {
                node = st2.pop();
                res2.add(node.val);
                System.out.println(node.val);
                continue;
            }
            if(node.right != null) {
                st2.push(node.right);
            }
            st2.push(node);
            st2.push(null);
            if(node.left != null) {
                st2.push(node.left);
            }
        }
        return res1.equals(res2);
    }
}