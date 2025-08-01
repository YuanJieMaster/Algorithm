package Greedy.Test1.Solution3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g, s));
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if(count < g.length && s[i] >= g[g.length - 1 - count]) count++;
        }
        return count;
    }
}