package GraphTheory.Test5.Solution1;

/**
 * 给定一个由`1`（陆地）和`0`（水）组成的矩阵，求通过将一块水域变为陆地后，岛屿的最大面积。
 * 在地图上的所有出生点开始跑图，当然，如果出生点是水的话就直接作废，而且跑图的过程中要标记已经探过的图，如果出生在已经探过的点也要作废。
 * dfs 写法
 * 但是这种方法 超时
 */

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {1,0},
            {0,1}
        }; // 3
        System.out.println(new Solution().largestIsland(grid));
    }
}

class Solution {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int max = 0;
        boolean isFull = true;
        boolean isEmpty = true;
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) isFull = false;
                if(grid[i][j] == 1) isEmpty = false;
            }
        }
        if (isFull) return length * length;
        if (isEmpty) return 1;
        int simpleMax = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[][] newGrid1 = new int[length][length];
                int[][] newGrid2 = new int[length][length];
                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        newGrid1[k][l] = grid[k][l];
                        newGrid2[k][l] = grid[k][l];
                    }
                }
                simpleMax = Math.max(simpleMax, dfs(newGrid1, i, j));
                if(grid[i][j] == 1) continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int next_i = i + dir[k][0];
                    int next_j = j + dir[k][1];
                    if(next_i < 0 || next_i >= length || next_j < 0 || next_j >= length) continue;
                    count += (grid[next_i][next_j] == 1)?1:0;
                }
                if(count < 2) continue;
                newGrid2[i][j] = 1;
                max = Math.max(max, dfs(newGrid2, i, j));
            }
        }
        return Math.max(max, simpleMax + 1);
    }
    public int dfs(int[][] grid, int i, int j) {
        int area = 0;
        int length = grid.length;
        if(grid[i][j] == 0 || grid[i][j] == 2) return 0;
        if(grid[i][j] == 1) {
            grid[i][j] = 2;
            area++;
            for (int k = 0; k < 4; k++) {
                int next_i = i + dir[k][0];
                int next_j = j + dir[k][1];
                if(next_i < 0 || next_i >= length || next_j < 0 || next_j >= length) continue;
                area += dfs(grid, next_i, next_j);
            }
        }
        return area;
    }
}