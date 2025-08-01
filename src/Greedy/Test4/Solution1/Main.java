package Greedy.Test4.Solution1;

public class Main {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int input = 0;
        int output = 0;
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] - prices[i] > 0) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}