package Greedy.Test2.Solution3;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(nums));
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length <= 1) return length;
        int[][] res = new int[length][2];
        for (int i = 0; i < length; i++) {
            res[i][0] = res[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] < nums[j]) res[i][1] = Math.max(res[i][1], res[j][0] + 1);
                if(nums[i] > nums[j]) res[i][0] = Math.max(res[i][0], res[j][1] + 1);
            }
        }
        return Math.max(res[length-1][0], res[length-1][1]);
    }
}