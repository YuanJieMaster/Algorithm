package Leetcode.Competition1.Test1;

public class Main {
    public static void main(String[] args) {
        int[] landStartTime = {2,8};
        int[] landDuration = {4,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        Solution solution = new Solution();
        System.out.println(solution.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // 先陆地后水下
                int landEndTime = landStartTime[i] + landDuration[i];
                int switchTimeLandToWater = Math.max(landEndTime, waterStartTime[j]);
                res = Math.min(res, switchTimeLandToWater + waterDuration[j]);

                // 先水下后陆地
                int waterEndTime = waterStartTime[j] + waterDuration[j];
                int switchTimeWaterToLand = Math.max(waterEndTime, landStartTime[i]);
                res = Math.min(res, switchTimeWaterToLand + landDuration[i]);
            }
        }
        return res;
    }
}