package DynamicProgramming.Test6.Solution1;

/**
 * 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */

public class Main {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().integerBreak(n));
    }
}

class Solution {
    public int integerBreak(int n) {
        if(n <= 1) return -1;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[2] = 1;
        dp[3] = 2;
        int maxProduct = 1;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                maxProduct = Math.max(maxProduct, Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
            }
            dp[i] = maxProduct;
        }
        return dp[n];
    }
}