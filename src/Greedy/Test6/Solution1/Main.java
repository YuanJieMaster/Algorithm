package Greedy.Test6.Solution1;

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
        int pre = 0;
        int count = 1;
        while(reach < nums.length - 1 && !(reach == pre)) {
            pre = reach;
            count++;
            int temp = reach;
            for (int i = 0; i <= temp; i++) {
                if(reach >= nums.length - 1) return count;
                if(i + nums[i] > reach) reach = i + nums[i];
            }
        }
        return count;
    }
}