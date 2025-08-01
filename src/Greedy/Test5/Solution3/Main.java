package Greedy.Test5.Solution3;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int reach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i <= reach) {
                reach = Math.max(reach, i + nums[i]);
                if (reach >= nums.length - 1) return true;
            }
        }
        return false;
    }
}