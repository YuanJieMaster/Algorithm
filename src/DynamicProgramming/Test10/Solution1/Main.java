package DynamicProgramming.Test10.Solution1;

/**
 * 目标和
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
//        int[] nums = {1,2,1};
//        int target = 0;
//        int[] nums = {9,7,0,3,9,8,6,5,7,6};
//        int target = 2;
        System.out.println(new Solution().findTargetSumWays(nums, target));
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if((sum - target) % 2 != 0 || sum < Math.abs(target)) return 0;
        int res = (sum - target) / 2;
        int[][] dp = new int[length][res + 1];
        int[][] count = new int[length][res + 1];
        for (int i = 0; i <= res; i++) {
            count[0][i] = 1;
        }
        for (int i = nums[0]; i <= res; i++) {
            dp[0][i] = nums[0];
            if(nums[0] == 0) count[0][i] += 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= res; j++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                    count[i][j] = count[i - 1][j];
                }
                else {
                    if(dp[i - 1][j - nums[i]] + nums[i] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j - nums[i]] + nums[i];
                        count[i][j] = count[i - 1][j - nums[i]];
                    } else if(dp[i - 1][j - nums[i]] + nums[i] < dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j];
                        count[i][j] = count[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        count[i][j] = count[i - 1][j - nums[i]] + count[i - 1][j];
                    }
                }
            }
        }
        return count[length - 1][res];
    }
}