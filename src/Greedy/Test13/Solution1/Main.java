package Greedy.Test13.Solution1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}}; // 1
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> { return a[1] - b[1];});
        Map<int[], Integer> map = new HashMap<int[], Integer>();
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], 1);
        }
        for (int i = 0; i < intervals.length; i++) {
            if(map.get(intervals[i]) == 0) continue;
            int right = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                if(map.get(intervals[j]) == 1 && intervals[j][0] < right) {
                    map.put(intervals[j], 0);
                    count++;
                }
            }
        }
        return count;
    }
}