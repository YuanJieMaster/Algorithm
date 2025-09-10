package DynamicProgramming.Test2.Solution1;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().climbStairs(n));
    }
}

class Solution {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}