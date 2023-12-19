package leetcode.Contest_All.双周赛.双周赛108.题3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2023年07月09日 15:08
 */
public class Solution {
    static Set<Integer> set = new HashSet<>();

    static {
        int num = 5;
        for (int i = 0; i <= 12; i++) {
            if (Math.pow(num, i) >= Math.pow(2, 15)) break;
            set.add((int) Math.pow(num, i));
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumBeautifulSubstrings("1011"));
    }

    public static int minimumBeautifulSubstrings(String s) {
        int ans = dfs(0, s);
        return ans == Integer.MAX_VALUE / 10 ? -1 : ans;
    }

    public static int dfs(int i, String s) {
        if (i == s.length()) return 0;
        if (s.charAt(i) == '0') return Integer.MAX_VALUE / 10;
        int ans = Integer.MAX_VALUE / 10;
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            int val = Integer.parseInt(sub, 2);
            if (set.contains(val)) {
                ans = Math.min(ans, dfs(j + 1, s) + 1);
            }
        }
        return ans;
    }
}