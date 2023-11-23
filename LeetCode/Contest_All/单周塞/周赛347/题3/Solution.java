package LeetCode.Contest_All.单周塞.周赛347.题3;

/**
 * @author Wu
 * @date 2023年05月28日 15:58
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    public long minimumCost(String S) {
        long ans = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 1; i < n; i++)
            if (s[i - 1] != s[i])
                ans += Math.min(i, n - i);
        return ans;
    }
}