package leetcode.Contest_All.单周塞.周赛350.题4;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年06月22日 22:05
 */
public class Solution {
    int[][] memo;
    int[] cost, time;
    int n;

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        this.cost = cost;
        this.time = time;
        memo = new int[n][2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, n);
    }

    public int dfs(int i, int j) {
        if (j - n > i) return 0;
        if (i < 0) return Integer.MAX_VALUE / 2;
        if (memo[i][j] != -1) return memo[i][j];
        int res = Math.min(dfs(i - 1, j + time[i]) + cost[i], dfs(i - 1, j - 1));
        memo[i][j] = res;
        return res;
    }
}