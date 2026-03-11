package MonotonicStack.Test2.Solution1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 单调栈找到目标，HashMap存储中间结果以便快速查询
 */

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        for (int i : new Solution().nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length2; i++) {
            Integer pop = 0;
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                pop = st.pop();
                map.put(nums2[pop], nums2[i]);
            }
            st.push(i);
        }
        int[] res = new int[length1];
        for (int i = 0; i < length1; i++) {
            Integer n = map.get(nums1[i]);
            if(n != null) {
                res[i] = n;
                continue;
            }
            res[i] = -1;
        }
        return res;
    }
}