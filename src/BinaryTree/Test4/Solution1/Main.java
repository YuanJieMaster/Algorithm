package BinaryTree.Test4.Solution1;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

/**
 * 用左右对称的层序遍历，对比结果
 */

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {1,2,2,3,4,4,3};
//        Integer[] input = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}

class TreeNodePlus {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    TreeNodePlus(TreeNode node){
        if(node != null) {
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
        } else {
            this.val = null;
            this.left = null;
            this.right = null;
        }
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left ==null && root.right == null) {
            return true;
        }
        ArrayList<Integer> ans_l = new ArrayList<>();
        Queue<TreeNodePlus> list_l = new LinkedList<>();
        list_l.add(new TreeNodePlus(root));
        while(!list_l.isEmpty()) {
            TreeNodePlus node = list_l.poll();
            if(node != null) {
                ans_l.add(node.val);
            }
            if(node.val != null) {
                list_l.add(new TreeNodePlus(node.left));
                list_l.add(new TreeNodePlus(node.right));
            }
        }
        ArrayList<Integer> ans_r = new ArrayList<>();
        Queue<TreeNodePlus> list_r = new LinkedList<>();
        list_r.add(new TreeNodePlus(root));
        while(!list_r.isEmpty()) {
            TreeNodePlus node = list_r.poll();
            if(node != null) {
                ans_r.add(node.val);
            }
            if(node.val != null) {
                list_r.add(new TreeNodePlus(node.right));
                list_r.add(new TreeNodePlus(node.left));
            }
        }
        return ans_l.equals(ans_r);
    }
}