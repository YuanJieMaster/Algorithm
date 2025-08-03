package Greedy.Test7.Solution1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,-1,0,2};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(nums, k));
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int index = Math.min(nums.length, k);
        for (int i = 0; i < nums.length && i < k; i++) {
            if(nums[i] >= 0) {
                index = i;
                break;
            }
            nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        if((k - index) % 2 == 1) nums[0] = -nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}