package DynamicProgramming.Test3.Solution1;

/**
 * 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个解体对应着一个非负数的体力花费值 cost[i] （下标从 0 开始）。
 * 每爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，你就可以向上爬一个阶梯或者两个阶梯。
 * 求到达顶部的最低体力花费。开始时，可以选择以下标为 0 或者 1 的阶梯作为初始阶梯。
 */

public class Main {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] res = new int[length + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i < length + 1; i++) {
            res[i] = Math.min(res[i-1] + cost[i-1], res[i-2] + cost[i-2]);
        }
        return res[length];
    }
}