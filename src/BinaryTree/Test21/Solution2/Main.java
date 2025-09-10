package BinaryTree.Test21.Solution2;


import BinaryTree.Common.TreeNode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        System.out.println(solution.sortedArrayToBST(nums));
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode root = new TreeNode(0);
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        LinkedList<Integer> starts = new LinkedList<>();
        LinkedList<Integer> ends = new LinkedList<>();
        treeNodes.offer(root);
        starts.offer(0);
        ends.offer(nums.length - 1);
        while(!treeNodes.isEmpty() && !starts.isEmpty() && !ends.isEmpty()) {
            TreeNode node = treeNodes.poll();
            Integer start = starts.poll();
            Integer end = ends.poll();
            int middle = (start + end) / 2;
            if(start <= end) {
                node.val = nums[middle];
            }
            if(start <= middle - 1) {
                TreeNode newNode = new TreeNode(nums[(start + middle - 1) / 2]);
                node.left = newNode;
                treeNodes.offer(newNode);
                starts.offer(start);
                ends.offer(middle - 1);
            }
            if(middle + 1 <= end) {
                TreeNode newNode = new TreeNode(nums[(middle + 1 + end) / 2]);
                node.right = newNode;
                treeNodes.offer(newNode);
                starts.offer(middle + 1);
                ends.offer(end);
            }
        }
        return root;
    }
}