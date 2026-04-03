package Hot100.Test8.Solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * 这道题我通过滑动窗口和哈希表来做，需要注意的是字符串中不只有字母，并且只有英文字母、数字、符号和空格，字符集应该是 ASCII
 * 若字符集更大，则用 HashSet 更通用
 */

public class Main {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int left = 0;
        int right = 0;
        int longest = 1;
        int[] alphabet = new int[128];
        char[] str = s.toCharArray();
        alphabet[str[0]]++;
        while(right < s.length() - 1) {
            right++;
            if(alphabet[str[right]] != 0) {
                while(str[left] != str[right]) {
                    alphabet[str[left]]--;
                    left++;
                }
                left++;
            } else alphabet[str[right]]++;
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}