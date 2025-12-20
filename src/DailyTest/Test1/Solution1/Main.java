package DailyTest.Test1.Solution1;

/**
 * 删列造序
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序非严格递增排列的 列。在上面的例子（下标从 0 开始）中，
 * 列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按字典序非严格递增排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 * 返回你需要删除的列数。
 */

public class Main {
    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        System.out.println(new Solution().minDeletionSize(strs));
    }
}

class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int columns = strs[0].length();
        int count = 0;
        for(int j = 0; j < columns; j++) {
            char bef = 'a';
            for(int i = 0; i < rows; i++) {
                if(strs[i].charAt(j) - bef < 0) {
                    count++;
                    break;
                }
                bef = strs[i].charAt(j);
            }
        }
        return count;
    }
}