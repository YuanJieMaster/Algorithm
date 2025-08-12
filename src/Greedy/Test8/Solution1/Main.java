package Greedy.Test8.Solution1;

/**
 * 加油站
 * 暴力解法
 */

public class Main {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasVolume;
        for (int i = 0; i < gas.length; i++) {
            gasVolume = 0;
            for (int j = 0; j < gas.length; j++) {
                gasVolume += gas[(i+j) % cost.length];
                gasVolume -= cost[(i+j) % cost.length];
                if(gasVolume < 0) break;
                if(j == gas.length - 1) return i;
            }
        }
        return -1;
    }
}