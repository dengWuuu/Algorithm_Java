package LeetCode.Y_2023.工作计划的最低难度;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年05月18日 0:00
 */
public class DfsSolution {
    int[] a;
    int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        a = jobDifficulty;
        int n = a.length;
        if (n < d) return -1;
        memo = new int[n][d + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, d);
    }

    //前i个j次划分的dfs
    public int dfs(int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        if (j == 1) {
            int mx = Integer.MIN_VALUE;
            for (int k = 0; k <= i; k++) {
                mx = Math.max(mx, a[k]);
            }
            return memo[i][j] = mx;
        }
        int res = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int k = i; k >= j - 1; k--) {
            mx = Math.max(mx, a[k]);
            res = Math.min(res, dfs(k - 1, j - 1) + mx);
        }
        return memo[i][j] = res;
    }
}
