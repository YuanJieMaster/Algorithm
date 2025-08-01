package Greedy.Test6.Solution2;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }
}

class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int reach = nums[0];
        int temp = reach;
        if(nums.length <= reach + 1) return 1;
        int count = 2;
        for (int i = 0; i < nums.length; i++) {
            if(i == temp + 1) {
                count++;
                temp = reach;
            }
            if(i <= temp) {
                reach = Math.max(reach, i + nums[i]);
                if (reach >= nums.length - 1) return count;
            }
        }
        return count;
    }
}