package BinaryTree.Test15.Solution1;

import BinaryTree.Common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static BinaryTree.Common.BinaryTreeBuilder.buildTree;

public class Main {
    public static void main(String[] args) {
        Integer[] input = {4,2,6,1,3}; // true
        TreeNode root = buildTree(input);
        Solution solution = new Solution();
        System.out.println(solution.findMode(root));
    }
}

class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        addMode(root, map);
        return getKeysOfMaxValue(map);
    }

    public void addMode(TreeNode root, Map<Integer, Integer> map) {
        if(map.containsKey(root.val)) {
            map.replace(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        if(root.left != null) {
            addMode(root.left, map);
        }
        if(root.right != null) {
            addMode(root.right, map);
        }
    }

    public int[] getKeysOfMaxValue(Map<Integer, Integer> map) {
        Integer maxValue = Collections.max(map.values());
        ArrayList<Integer> maxKeys = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue().equals(maxValue)) {
                maxKeys.add(entry.getKey());
            }
        }
        int[] res = new int[maxKeys.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxKeys.get(i);
        }
        return res;
    }
}