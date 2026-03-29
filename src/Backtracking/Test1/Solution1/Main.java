package Backtracking.Test1.Solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(new Solution().combine(n, k));
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || n < k) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        if(n == k) {
            List<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> comb = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                comb.add(i);
            }
            res.add(comb);
            return res;
        };
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> sub_res1 = combine(n - 1, k - 1);
        for (List<Integer> comb : sub_res1) {
            comb.add(n);
            res.add(comb);
        }
        List<List<Integer>> sub_res2 = combine(n - 1, k);
        res.addAll(sub_res2);
        return res;
    }
}