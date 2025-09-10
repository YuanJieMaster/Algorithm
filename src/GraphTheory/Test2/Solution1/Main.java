package GraphTheory.Test2.Solution1;

/**
 * 给定一个由`1`（陆地）和`0`（水）组成的矩阵，求岛屿数量。
 * 在地图上的所有出生点开始跑图，当然，如果出生点是水的话就直接作废，而且跑图的过程中要标记已经探过的图，如果出生在已经探过的点也要作废。
 */

public class Main {
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += walkAroundIsland(grid, i, j);
            }
        }
        return count;
    }
    public int walkAroundIsland(char[][] grid, int i, int j) {
        if(grid.length == 0) return 0;
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if(grid[i][j] == '0' || grid[i][j] == '2') return 0;
        if(grid[i][j] == '1') grid[i][j] = '2';
        walkAroundIsland(grid, i, j-1);
        walkAroundIsland(grid, i, j+1);
        walkAroundIsland(grid, i+1, j);
        walkAroundIsland(grid, i-1, j);
        return 1;
    }
}