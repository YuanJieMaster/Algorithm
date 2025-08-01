package Greedy.Test2.Solution2;

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
        int pre = 0;
        for(n = 1; n < nums.length; n++) {
            pre = nums[n] - nums[n-1];
            if(pre != 0) break;
        }
        if(pre == 0) return 1;
        int count = 2;
        for(int i = n+1; i < nums.length; i++) {
            int cur = nums[i] - nums[i-1];
            if(cur * pre < 0) {
                count++;
                pre = cur;
            }
        }
        return count;
    }
}