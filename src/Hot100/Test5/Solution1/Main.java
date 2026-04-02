package Hot100.Test5.Solution1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 对于这道题有点错误的印象，之前有道很相似的题是用单调栈来做的，但是那道题求的是把所有隔板都考虑进来能盛最多的水
 * 这道题求的是选择其中两个隔板能盛的最多水，我考虑用双指针和贪心来做
 */

public class Main {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7}; // 49
        System.out.println(new Solution().maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if(length < 2) return 0;
        int left = 0;
        int right = length - 1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}