package leetcode.Contest_All.单周塞.周赛385.题4;

import template.筛子.筛法;

import java.util.*;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */
public class Solution {
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
}
