package Backtracking.Test1.Solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 这次用常规方法，回溯递归实现 n 重循环，多了显式回溯这个过程
 */

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(new Solution().combine(n, k));
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int startIndex) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}