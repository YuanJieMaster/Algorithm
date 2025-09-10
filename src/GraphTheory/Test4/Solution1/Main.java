package GraphTheory.Test4.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 太平洋大西洋水流问题
 * 给定一个二维矩阵，用来表示一个岛的地形图，矩阵中每个元素的值表示其海拔，矩阵的左边界和上边界属于太平洋，右边界和下边界属于大西洋，
 * 现在岛上下雨，雨水会向四个方向小于等于自己的海拔的方向流动，求雨水既可以流向太平洋和大西洋的地点坐标。
 * dfs 写法
 */

public class Main {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }; // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        System.out.println(new Solution().pacificAtlantic(heights));
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                boolean[][] reached = new boolean[heights.length][heights[0].length];
                if(dfs(heights, reached, i, j) == 3) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // 深搜 返回0表示流不到 返回1表示能流到太平洋 返回2表示能流到大西洋 返回3表示两边都能流到
    public int dfs(int[][] heights, boolean[][] reached, int i, int j) {
        if(heights.length == 0) return 0;
        boolean pacific = false;
        boolean atlantic = false;
        reached[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int next_i = i+dir[k][0];
            int next_j = j+dir[k][1];
            if(next_i < 0 || next_j < 0) {
                pacific = true;
                continue;
            }
            if(next_i > heights.length - 1 || next_j > heights[0].length - 1) {
                atlantic = true;
                continue;
            }
            if(reached[next_i][next_j]) continue;
            if(heights[next_i][next_j] > heights[i][j]) continue;
            int flag = dfs(heights, reached, next_i, next_j);
            if(flag == 1) pacific = true;
            if(flag == 2) atlantic = true;
            if(flag == 3) return 3;
        }
        if(pacific && atlantic) return 3;
        if(pacific) return 1;
        if(atlantic) return 2;
        return 0;
    }
}