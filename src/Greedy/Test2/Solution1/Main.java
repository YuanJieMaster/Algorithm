package Greedy.Test2.Solution1;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(nums));
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int n;
        int pre = nums[1] - nums[0];
        int count = (nums[1] == nums[0]) ? 1 : 2;
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i] - nums[i-1];
            if(pre <= 0 && cur > 0 || pre >= 0 && cur < 0) {
                count++;
                pre = cur;
            }
        }
        return count;
    }
}