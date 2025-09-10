package DynamicProgramming.Test1.Solution2;

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
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}