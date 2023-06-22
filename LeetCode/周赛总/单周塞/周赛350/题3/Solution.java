package LeetCode.周赛总.单周塞.周赛350.题3;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年06月22日 21:39
 */
public class Solution {
    int MOD = (int) (1e9 + 7);
    int[][] memo;
    int[] nums;

    public int specialPerm(int[] nums) {
        this.nums = nums;
        int ans = 0, n = nums.length, m = 1 << n;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs((m - 1) ^ (1 << i), i)) % MOD;
        }
        return ans;
    }

    int dfs(int i, int j) {
        if (i == 0) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        for (int k = 0; k < nums.length; k++) {
            if (((i >> k) & 1) > 0 && check(nums[k], nums[j])) {
                res = (res + dfs(i ^ (1 << k), k)) % MOD;
            }
        }
        memo[i][j] = res;
        return res;
    }

    public boolean check(int x, int y) {
        return x % y == 0 || y % x == 0;
    }
}
