package DynamicProgramming.Test12.Solution1;

/**
 * 零钱兑换II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */

public class Main {
    public static void main(String[] args) {
//        int amount = 5;
//        int[] coins = {1, 2, 5};
        int amount = 500;
        int[] coins = {2, 7, 13};
        System.out.println(new Solution().change(amount, coins));
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int kinds = coins.length;
        int[][] dp = new int[kinds][amount + 1];
        int[][] count = new int[kinds][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) count[0][i] = 1;
        }
        for (int i = 1; i < kinds; i++) {
            for (int j = 0; j <= amount; j++) {
                if(j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                    count[i][j] = count[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - coins[i]] + coins[i]);
                    count[i][j] = count[i][j - coins[i]] + count[i - 1][j];
                }
            }
        }
        return count[kinds - 1][amount];
    }
}