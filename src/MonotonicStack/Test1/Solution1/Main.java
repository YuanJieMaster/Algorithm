package MonotonicStack.Test1.Solution1;

/**
 * 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 暴力解法，两层循环，超时
 */

public class Main {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(new Solution().dailyTemperatures(temperatures));
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}