package DynamicProgramming.Test2.Solution2;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().climbStairs(n));
    }
}

class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        int a = 1;
        int b = 1;
        for (int i = 0; i < n-1; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}