package Greedy.Test14.Solution1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij"; // [9,7,8]
        System.out.println(new Solution().partitionLabels(s));
    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int[] ends = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            ends[charArray[i] - 'a'] = i;
        }
        int end = 0;
        int start = -1;
        for (int i = 0; i < charArray.length; i++) {
            end = Math.max(end, ends[charArray[i] - 'a']);
            if(i == end) {
                res.add(end - start);
                start = end;
            }
        }
        return res;
    }
}