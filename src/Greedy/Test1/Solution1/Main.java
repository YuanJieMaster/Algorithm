package Greedy.Test1.Solution1;

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
        int j = g.length - 1;
        int count = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            while(j >= 0 && (s[i] < g[j])) {
                j--;
            }
            if(j < 0) {
                return count;
            }
            count++;
            j--;
        }
        return count;
    }
}