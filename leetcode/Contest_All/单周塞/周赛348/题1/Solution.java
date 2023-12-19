package leetcode.Contest_All.单周塞.周赛348.题1;

/**
 * @author Wu
 * @date 2023年06月04日 14:56
 */
public class Solution {
    public int minimizedStringLength(String s) {
        int ans = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] == 1) ans++;
        }
        return ans;
    }
}
