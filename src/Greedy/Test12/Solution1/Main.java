package Greedy.Test12.Solution1;

import java.util.ArrayList;

/**
 * 用最少数量的箭引爆气球
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
        int arrows = 0;
        ArrayList<int[]> balls = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            balls.add(points[i]);
        }
        while(!balls.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < balls.size(); i++) {
                if (balls.get(i)[1] < min) min = balls.get(i)[1];
            }
            for (int i = 0; i < balls.size(); i++) {
                if (balls.get(i)[0] <= min && balls.get(i)[1] >= min) {
                    balls.remove(i);
                    i--;
                }
            }
            arrows++;
        }
        return arrows;
    }
}