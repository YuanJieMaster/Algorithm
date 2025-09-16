package GraphTheory.Test5.Solution2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个由`1`（陆地）和`0`（水）组成的矩阵，求通过将一块水域变为陆地后，岛屿的最大面积。
 * 在地图上的所有出生点开始跑图，每块岛屿标记不同的记号。
 * 最后尽可以地连接岛屿
 * dfs 写法
 */

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {1,0,1},
            {0,0,0},
            {0,1,1}
        }; // 4
//        int[][] grid = {
//            {1,0},
//            {0,1}
//        }; // 3
        System.out.println(new Solution().largestIsland(grid));
    }
}

class Solution {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        boolean isFull = true;
        boolean isEmpty = true;
        int length = grid.length;
        int mark = 2;
        int simpleMax = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) isFull = false;
                if(grid[i][j] == 1) isEmpty = false;
                int area = dfs_mark(grid, i, j, mark);
                simpleMax = Math.max(simpleMax, area);
                if(area != 0) map.put(mark++, area);
            }
        }
        if (isFull) return length * length;
        if (isEmpty) return 1;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) continue;
                int unitedArea = 1;
                int count = 0;
                HashSet<Integer> united = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int next_i = i + dir[k][0];
                    int next_j = j + dir[k][1];
                    if(next_i < 0 || next_i >= length || next_j < 0 || next_j >= length || grid[next_i][next_j] == 0) continue;
                    united.add(grid[next_i][next_j]);
                    count++;
                }
                if(count < 2) continue;
                for (Integer integer : united) {
                    unitedArea += map.get(integer);
                }
                maxArea = Math.max(maxArea, unitedArea);
            }
        }
        return Math.max(simpleMax + 1, maxArea);
    }
    public int dfs_mark(int[][] grid, int i, int j, int mark) {
        int area = 0;
        int length = grid.length;
        if(grid[i][j] != 1) return 0;
        grid[i][j] = mark;
        area++;
        for (int k = 0; k < 4; k++) {
            int next_i = i + dir[k][0];
            int next_j = j + dir[k][1];
            if(next_i < 0 || next_i >= length || next_j < 0 || next_j >= length) continue;
            area += dfs_mark(grid, next_i, next_j, mark);
        }
        return area;
    }
}