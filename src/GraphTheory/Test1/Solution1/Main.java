package GraphTheory.Test1.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}}; // [[0,1,3],[0,2,3]]
        System.out.println(new Solution().allPathsSourceTarget(graph));
    }
}

class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        findPathSourceTarget(graph, 0, new ArrayList<>(Arrays.asList(0)));
        return res;
    }
    public void findPathSourceTarget(int[][] graph, int cur, List<Integer> path) {
        if(cur >= graph.length) return ;
        for (int i : graph[cur]) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            newPath.add(i);
            if(i == graph.length - 1) res.add(newPath);
            findPathSourceTarget(graph, i, newPath);
        }
    }
}