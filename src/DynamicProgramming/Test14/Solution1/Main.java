package DynamicProgramming.Test14.Solution1;

/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 */

public class Main {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
//        int[] coins = {1, 2};
//        int amount = 2;
        int[] coins = {2,5,10,1};
        int amount = 27;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int kinds = coins.length;
        int[][] dp = new int[kinds][amount + 1];
        for (int i = 1; i <= amount; i++) {
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = Integer.MAX_VALUE - amount;
        }
        for (int i = 0; i < kinds; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < kinds; i++) {
            for (int j = 0; j <= amount; j++) {
                if(j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        if(dp[kinds - 1][amount] >= Integer.MAX_VALUE - amount) return -1;
        return dp[kinds - 1][amount];
    }
}