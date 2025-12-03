package DynamicProgramming.Test9.Solution1;

/**
 * 最后一块石头的重量II
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 */

public class Main {
    public static void main(String[] args) {
//        int[] stones = {2,7,4,1,8,1};
        int[] stones = {31,26,33,21,40};
        System.out.println(new Solution().lastStoneWeightII(stones));
    }
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int length = stones.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[length][target + 1];
        for (int i = stones[0]; i <= target; i++) {
            dp[0][i] = stones[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= target; j++) {
                if(j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[length - 1][target] * 2;
    }
}