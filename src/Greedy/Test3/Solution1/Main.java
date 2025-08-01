package Greedy.Test3.Solution1;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length <= 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum > max) max = sum;
            }
        }
        return max;
    }
}