package MonotonicStack.Test1.Solution2;

import java.util.Stack;

/**
 * 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 单调栈
 */

public class Main {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        for (int i : new Solution().dailyTemperatures(temperatures)) {
            System.out.println(i + " ");
        }
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                Integer pop = st.pop();
                res[pop] = i - pop;
            }
            st.push(i);
        }
        return res;
    }
}