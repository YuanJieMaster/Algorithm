package Hot100.Test9.Solution2;

/**
 * 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * 本题的关键在于如何确定目标字符串的每个字符都不重复地出现了一遍
 * 需要注意的是目标字符串可能出现重复字母
 * 用数组做哈希表会更快
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Solution().findAnagrams(s, p));
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] str = s.toCharArray();
        int[] window = new int[26];
        char[] target = p.toCharArray();
        int temp = 0;
        int[] check = new int[26];
        ArrayList<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        for (int i = 0; i < p.length(); i++) {
            check[target[i] - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            window[str[i] - 'a']++;
        }
        boolean equalsCheck = true;
        for (int i = 0; i < 26; i++) {
            if(window[i] != check[i]) equalsCheck = false;
        }
        if(equalsCheck) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            window[str[temp] - 'a']--;
            window[str[i] - 'a']++;
            equalsCheck = true;
            for (int k = 0; k < 26; k++) {
                if(window[k] != check[k]) equalsCheck = false;
            }
            if(equalsCheck) res.add(temp + 1);
            temp++;
        }
        return res;
    }
}