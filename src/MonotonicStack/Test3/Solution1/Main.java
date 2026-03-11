package MonotonicStack.Test3.Solution1;

import java.util.Stack;

/**
 * 下一个更大元素II
 * 循环数组，只需要循环两边即可
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        for (int i : new Solution().nextGreaterElements(nums)) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < length * 2; i++) {
            while(!st.isEmpty() && nums[st.peek() % length] < nums[i % length]) {
                Integer pop = st.pop();
                res[pop % length] = nums[i % length];
            }
            st.push(i);
        }
        return res;
    }
}