package LeetCode.Contest_All.双周赛.双周赛106.题2;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean f = false;
            for (int j = i; j < s.length(); j++) {
                if (j != i && s.charAt(j) == s.charAt(j - 1)) {
                    if (!f) f = true;
                    else {
                        break;
                    }
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}