package leetcode.Contest_All.单周塞.周赛385.题4;

import template.筛子.筛法;

import java.util.*;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */
public class Solution {
    // 字典树做法
    public long countPrefixSuffixPairs(String[] words) {
        long ans = 0;
        Node root = new Node();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Node cur = root;
            for (int i = 0; i < arr.length; i++) {
                int key = (arr[i] - 'a') << 5 | (arr[arr.length - i - 1] - 'a');
                if (cur.map.containsKey(key)) {
                    cur = cur.map.get(key);
                    ans += cur.cnt;
                    continue;
                }
                Node node = new Node();
                cur.map.put(key, node);
                cur = node;
            }
            cur.cnt++;
        }
        return ans;
    }
    /* 字符串哈希改进做法
    public long countPrefixSuffixPairs(String[] words) {
        long ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            for (int j = 1; j <= s.length(); j++) {
                String pre = s.substring(0, j);
                String suf = s.substring(s.length() - j);
                if (!pre.equals(suf)) continue;
                if (map.containsKey(pre)) ans += map.get(pre);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ans;
    }
     */
}

class Node {
    public int cnt;
    public Map<Integer, Node> map;

    public Node() {
        cnt = 0;
        map = new HashMap<>();
    }
}

