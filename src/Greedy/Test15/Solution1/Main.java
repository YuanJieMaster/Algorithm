package Greedy.Test15.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; // [[1,6],[8,10],[15,18]]
//        int[][] intervals = {{1,4},{4,5}}; // [[1,5]]
        int[][] intervals = {{1,4},{2,3}}; // [[1,4]]
        System.out.println(new Solution().merge(intervals));
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
            }
            end = Math.max(end, intervals[i][1]);
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}