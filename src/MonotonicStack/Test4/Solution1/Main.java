package MonotonicStack.Test4.Solution1;

import java.util.Stack;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * （~~也是很有想象力了~~）
 * 考虑短板（两侧较短边），也就是说我们需要知道每个格子左右两边的最大值即可
 * 但是这个问题和单调栈的典型例子不一样了
 * 我们需要在典型例子上再进一步，通过最近的较大值一直递推出最大值
 */

public class Main {
    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
        int[] height = {4,2,0,3,2,5}; // 9
        System.out.println(new Solution().trap(height));
    }
}

class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] res1 = new int[length];
        int[] res2 = new int[length];
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            res1[i] = -1;
        }
        for (int i = 0; i < length; i++) {
            res2[i] = -1;
        }
        for (int i = 0; i < length; i++) {
            while(!st1.isEmpty() && height[st1.peek()] < height[i]) {
                Integer pop = st1.pop();
                res1[pop] = i;
            }
            st1.push(i);
        }
        for (int i = length - 1; i >= 0; i--) {
            while(!st2.isEmpty() && height[st2.peek()] < height[i]) {
                Integer pop = st2.pop();
                res2[pop] = i;
            }
            st2.push(i);
        }
        for (int i = 0; i < length; i++) {
            int temp = res1[i];
            while(temp != -1 && res1[temp] != -1 && height[temp] < height[res1[temp]]) {
                res1[i] = res1[temp];
                temp = res1[temp];
            }
            temp = res2[i];
            while(temp != -1 && res2[temp] != -1 && height[temp] < height[res2[temp]]) {
                res2[i] = res2[temp];
                temp = res2[temp];
            }
            if(res1[i] == -1 || res2[i] == -1) continue;
            int min = Math.min(height[res1[i]], height[res2[i]]);
            if(min - height[i] > 0) sum += min - height[i];
        }
        return sum;
    }
}