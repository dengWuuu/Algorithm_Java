package LeetCode.周赛总.单周塞.周赛348.题4;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年06月04日 14:56
 */
public class Solution {
    long MOD = (long) (1e9 + 7);

    long[][] dp;
    int min, max;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        min = min_sum;
        max = max_sum;
        dp = new long[num1.length()][9 * num1.length() + 1];
        for (long[] longs : dp) {
            Arrays.fill(longs, -1);
        }
        long l = f(num1.toCharArray(), 0, 0, true);

        dp = new long[num2.length()][9 * num2.length() + 1];
        for (long[] longs : dp) {
            Arrays.fill(longs, -1);
        }
        long r = f(num2.toCharArray(), 0, 0, true);
        long ans = (r - l + MOD) % MOD;

        int sum = 0;
        for (int i = 0; i < num1.length(); i++) {
            sum += num1.charAt(i) - '0';
        }
        if (sum >= min && sum <= max) ans = (ans + 1) % MOD;

        return (int) ans;
    }

    public long f(char[] s, int i, int mask, boolean limit) {
        if (mask > max) return 0;
        if (i == s.length) return mask >= min ? 1 : 0;
        if (!limit && dp[i][mask] != -1) return dp[i][mask];
        long res = 0;
        int up = limit ? s[i] - '0' : 9;
        for (int j = 0; j <= up; j++) {
            res = (res + f(s, i + 1, mask + j, limit && j == up)) % MOD;
        }
        if (!limit) dp[i][mask] = res;
        return res;
    }
}
