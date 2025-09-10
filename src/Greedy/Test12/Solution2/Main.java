package Greedy.Test12.Solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * 化简算法
 */

public class Main {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}}; // 2
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparing(a -> a[1]));
        int arrows = 1;
        int end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if(points[i][0] > end) {
                end = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}