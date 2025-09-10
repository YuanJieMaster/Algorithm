package DynamicProgramming.Test1.Solution1;

public class Main {
    public static void main(String[] args) {
        int n = 4; // 3
        System.out.println(new Solution().fib(n));
    }
}

class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n - 2) + fib(n - 1);
    }
}