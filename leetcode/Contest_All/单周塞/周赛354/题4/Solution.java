package leetcode.Contest_All.单周塞.周赛354.题4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wu
 * @date 2023年07月16日 13:10
 */
public class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int l = 0, r = 0;
        int ans = 0;
        Set<String> set = new HashSet<>(forbidden);
        while (r < word.length()) {
            for (int i = r; i >= l && i > r - 10; i--) {
                if (set.contains(word.substring(i, r + 1))) {
                    l = i + 1;
                    break;
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}