package DynamicProgramming.Test8.Solution1;

/**
 * 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,5,11,5};
//        int[] nums = {1,1};
        int[] nums = {3, 3, 3, 4, 5};
        System.out.println(new Solution().canPartition(nums));
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[length][target+1];
        for (int i = nums[0]; i <= target; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = nums[0]; j <= target; j++) {
                if(j <= nums[i]) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j-nums[i]] + nums[i]);
            }
        }
        return dp[length - 1][target] == target;
    }
}