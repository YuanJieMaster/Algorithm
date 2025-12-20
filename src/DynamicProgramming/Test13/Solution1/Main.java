package DynamicProgramming.Test13.Solution1;

/**
 * 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 */

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        int target = 4;
        int[] nums = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int target = 10;
        System.out.println(new Solution().combinationSum4(nums, target));
    }
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i < nums[j]) continue;
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}