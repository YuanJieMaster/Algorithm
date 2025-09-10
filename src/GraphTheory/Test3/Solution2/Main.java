package GraphTheory.Test3.Solution2;

import java.util.LinkedList;

/**
 * 给定一个由`1`（陆地）和`0`（水）组成的矩阵，求岛屿数量。
 * 在地图上的所有出生点开始跑图，当然，如果出生点是水的话就直接作废，而且跑图的过程中要标记已经探过的图，如果出生在已经探过的点也要作废。
 * bfs 写法
 */

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1}
        };
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, walkAroundIsland_bfs(grid, i, j));
            }
        }
        return maxArea;
    }
    public static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int walkAroundIsland_bfs(int[][] grid, int i, int j) {
        if(grid.length == 0) return 0;
        if (grid[i][j] == 0 || grid[i][j] == 2) return 0;
        LinkedList<int[]> list = new LinkedList<>();
        list.push(new int[]{i, j});
        int area = 0;
        grid[i][j] = 2;
        while(!list.isEmpty()) {
            int[] coord = list.poll();
            i = coord[0];
            j = coord[1];
            area++;
            for (int k = 0; k < 4; k++) {
                int next_i = i + +dir[k][0];
                int next_j = j + +dir[k][1];
                if (next_i < 0 || next_i >= grid.length || next_j < 0 || next_j >= grid[0].length) continue;
                if (grid[next_i][next_j] == 0 || grid[next_i][next_j] == 2) continue;
                if (grid[next_i][next_j] == 1) {
                    grid[next_i][next_j] = 2;
                    list.push(new int[]{next_i, next_j});
                }
            }
        }
        return area;
    }
}