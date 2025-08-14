package Greedy.Test10.Solution3;

public class Main {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        Solution solution = new Solution();
        System.out.println(solution.lemonadeChange(bills));
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change_five = 0;
        int change_ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                change_five++;
            }
            if(bills[i] == 10) {
                change_five--;
                if(change_five < 0) return false;
                change_ten++;
            }
            if(bills[i] == 20) {
                if(change_ten > 0) {
                    change_ten--;
                    change_five--;
                    if(change_five < 0) {
                        return false;
                    }
                } else {
                    change_five -= 3;
                    if(change_five < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}