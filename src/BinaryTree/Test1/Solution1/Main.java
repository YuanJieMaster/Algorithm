package BinaryTree.Test1.Solution1;

import BinaryTree.Common.*;

import java.util.ArrayList;
import java.util.List;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {
        // 根据输入构建二叉树
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        for(List<Integer> list: lists) {
            for(Integer value: list) {
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {


        ArrayList<List<Integer>> res = new ArrayList<>();

        // 如果根节点为空
        if(root == null) {
            return res;
        }

        // 求出树的高度
        int n = countTreeHowHigh(root, 1);
        System.out.println(n);

        // 将第n层的所有节点的值存入ArrayList
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            addList(root, i, list);
            res.add(list);
        }

        return res;
    }

    /**
     * 求出树的高度,需要输入n=1
     * @param root
     * @param n
     * @return
     */
    public int countTreeHowHigh(TreeNode root ,int n) {
        int left = 0;
        int right = 0;
        if(root.left != null) {
            left = countTreeHowHigh(root.left, n+1);
        }
        if(root.right != null) {
            right = countTreeHowHigh(root.right, n+1);
        }
        return max(max(left, right), n);
    }

    /**
     * 输入当前子树的根节点和树高n，将子树的n高的节点的值存入ArrayList中
     * @param cur
     * @param n
     * @param list
     */
    public void addList(TreeNode cur, int n, ArrayList<Integer> list) {
        if(n == 1) {
            list.add(cur.val);
            return;
        }
        if(cur.left != null) {
            addList(cur.left, n-1, list);
        }
        if(cur.right != null) {
            addList(cur.right, n-1, list);
        }
    }
}