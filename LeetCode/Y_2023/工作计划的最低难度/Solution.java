package LeetCode.Y_2023.工作计划的最低难度;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年05月17日 18:39
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    int[] a;
    int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        a = jobDifficulty;
        int n = a.length;
        if (n < d) return -1;
        memo = new int[d][n];

        for (int i = 0; i < d; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(d - 1, n - 1);
    }

    public int dfs(int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        if (i == 0) {
            int mx = 0;
            for (int k = 0; k <= j; k++) {
                mx = Math.max(mx, a[k]);
            }
            return memo[i][j] = mx;
        }
        int res = Integer.MAX_VALUE;
        int mx = 0;
        for (int k = j; k >= i; k--) {
            mx = Math.max(mx, a[k]);
            res = Math.min(res, dfs(i - 1, k - 1) + mx);
        }
        return memo[i][j] = res;
    }
}
