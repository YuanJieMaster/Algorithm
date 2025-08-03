package Leetcode.Competition1.Test2.Solution1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,6,2,9};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.minRemoval(nums, k));
    }
}

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[nums.length - 1] <= nums[0] * k) return 0;
        // 去掉最小值
        int withOutFirst = minRemoval(Arrays.copyOfRange(nums, 1, nums.length), k);

        // 去掉最大值
        int withOutLast = minRemoval(Arrays.copyOfRange(nums, 0, nums.length - 1), k);

        return Math.min(withOutFirst, withOutLast) + 1;
    }
}