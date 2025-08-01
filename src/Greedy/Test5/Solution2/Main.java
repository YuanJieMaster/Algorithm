package Greedy.Test5.Solution2;

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
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if(reach < i) return false;
            if(i + nums[i] > reach) reach = i + nums[i];
            if(reach >= nums.length - 1) return true;
        }
        return false;
    }
}