package Greedy.Test9.Solution1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        int[] ratings = {1,0,2};
//        int[] ratings = {1,2,3,1,0};
        int[] ratings = {1,6,10,8,7,3,2};
        Solution solution = new Solution();
        System.out.println(solution.candy(ratings));
    }
}

class Solution {
    public int candy(int[] ratings) {
        int candy = ratings.length;
        int pre = 1;
        int[] gap = new int[ratings.length];
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                gap[i + 1] = ratings.length;
                candy += pre++;
            }
            else if (ratings[i] > ratings[i + 1]) {
                if(pre == 1) {
                    candy += preAllot(gap, i);
                } else {
                    gap[i + 1] = pre - 2;
                    pre = 1;
                }
            } else {
                gap[i + 1] = ratings.length;
                pre = 1;
            }
        }
        return candy;
    }

    public int preAllot(int[] gap, int index) {
        for (int i = index; i >= 0; i--) {
            if(gap[i] != 0) {
                gap[i]--;
                return index - i + 1;
            }
        }
        return index + 1;
    }
}