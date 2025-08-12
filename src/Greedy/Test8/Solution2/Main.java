package Greedy.Test8.Solution2;

/**
 * 加油站
 * 
 */

public class Main {
    public static void main(String[] args) {
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        int[] gas = {3,1,1};
//        int[] cost = {1,2,2};
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int gasVolume = gas[start] - cost[cost.length - 1];
        while(start > 0 && gasVolume < 0) {
            start--;
            gasVolume += gas[start] - cost[start];
        }
        if(gasVolume < 0) return -1;
        if(start == 0) return start;
        for (int i = 0; i < gas.length; i++) {
            gasVolume += gas[i % cost.length] - cost[i % cost.length];
            while(start > i && gasVolume < 0) {
                start--;
                gasVolume += gas[start] - cost[start];
            }
            if(gasVolume < 0) return -1;
            if(i == start) return i;
        }
        return -1;
    }
}