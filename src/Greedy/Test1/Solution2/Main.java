package Greedy.Test1.Solution2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g, s));
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if(count < g.length && g[count] <= s[i]) {
                count++;
            }
        }
        return count;
    }
}