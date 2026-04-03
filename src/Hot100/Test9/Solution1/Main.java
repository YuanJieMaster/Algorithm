package Hot100.Test9.Solution1;

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
 * 而且采取滑动窗口的好处就是可以通过每次滑动的差量进行判断，将时间复杂度从O(n*m)降到O(n)
 * 还有要知道，创建一个对象的开销是远远大于一次计算或一次取值的
 * 所以不要采用增删目标字符 Map 键值对最后通过判空进行比较这种方案，因为这样每次滑动窗口都需要重新构建
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        HashMap<Character, Integer> window = new HashMap<>();
        char[] target = p.toCharArray();
        int temp = 0;
        HashMap<Character, Integer> check = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        for (int i = 0; i < p.length(); i++) {
            check.computeIfAbsent(target[i], key -> 0);
            check.put(target[i], check.get(target[i]) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            window.computeIfAbsent(str[i], key -> 0);
            window.put(str[i], window.get(str[i]) + 1);
        }
        if(window.equals(check)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            window.put(str[temp], window.get(str[temp]) - 1);
            if(window.get(str[temp]) == 0) window.remove(str[temp]);
            window.computeIfAbsent(str[i], key -> 0);
            window.put(str[i], window.get(str[i]) + 1);
            if(window.equals(check)) res.add(temp + 1);
            temp++;
        }
        return res;
    }
}