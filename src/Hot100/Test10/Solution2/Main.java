package Hot100.Test10.Solution2;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * 滑动窗口经典题目
 * 需要注意的是数组元素不一定是正整数，所以不能通过简单地与目标比较确定滑动方向
 * 这种连续子数组就应该想到前缀和（积分），根据题意我们还可以使用哈希表进行优化
 * 还有一点要注意，前缀和要包含空前缀
 */

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1};
//        int k = 2;
        int[] nums = {-1, -1, 1};
        int k = 0;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}