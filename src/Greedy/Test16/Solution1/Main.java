package Greedy.Test16.Solution1;

/**
 * 给定一个非负整数，求小于等于这个整数的，满足各个数位的数单调递增（可相等）的最大整数。
 */

public class Main {
    public static void main(String[] args) {
//        int n = 332; // 299
//        int n = 1234; // 1234
//        int n = 101; // 99
        int n = 10; // 9
        System.out.println(new Solution().monotoneIncreasingDigits(n));
    }
}

class Solution {
    public int monotoneIncreasingDigits(int n) {
        int ori = n;
        int flag = 0;
        int pre = n % 10;
        int count = -1;
        while(n > 0) {
            count++;
            int end = n % 10;
            if(end > pre) {
                flag += count;
                count = 0;
            }
            pre = end - ((end > pre)?1:0);
            n /= 10;
        }
        if(flag == 0) return ori;
        return (ori / (int)Math.pow(10, flag)) * (int)Math.pow(10, flag) - 1;
    }
}