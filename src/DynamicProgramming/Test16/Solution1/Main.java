package DynamicProgramming.Test16.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */

public class Main {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if(wordDict.contains(s.substring(j, i)) && dp[j]) dp[i] = true;
            }
        }
        return dp[length];
    }
}