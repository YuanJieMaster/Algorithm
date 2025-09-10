package BinaryTree.Test21.Solution1;


import BinaryTree.Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        System.out.println(solution.sortedArrayToBST(nums));
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = new TreeNode(nums[nums.length / 2]);
        return sortedArrayToBSTNode(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBSTNode(int[] nums, int start, int end) {
        if(start > end) return null;
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBSTNode(nums, start, middle - 1);
        node.right = sortedArrayToBSTNode(nums, middle + 1, end);
        return node;
    }
}