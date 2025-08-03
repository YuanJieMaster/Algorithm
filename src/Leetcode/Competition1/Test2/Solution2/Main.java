package Leetcode.Competition1.Test2.Solution2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,1,5};
//        int[] nums = {1,6,2,9};
//        int[] nums = {4,6};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.minRemoval(nums, k));
    }
}

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums.length - 1;
        for (int left = 0; left < nums.length; left++) {
            int right = left;
            int pre = right;
            while(right < nums.length && nums[right] <= (long) nums[left] * k) {
                pre = right;
                right = (nums.length + right) / 2 + 1;
            }
            int end = right;
            right = pre;
            while(right < end && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            res = Math.min(res, nums.length - (right - left));
        }
        return res;
    }
}