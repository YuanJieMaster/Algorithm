package Greedy.Test11.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution solution = new Solution();
        System.out.println(solution.reconstructQueue(people));
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            queue.add(people[i][1], people[i]);
        }
        return queue.toArray(new int[people.length][]);
    }
}