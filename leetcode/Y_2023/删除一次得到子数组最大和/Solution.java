package leetcode.Y_2023.删除一次得到子数组最大和;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年06月28日 22:22
 */
public class Solution {
    int[] arr;
    int[][] memo;

    public int maximumSum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        this.arr = arr;
        memo = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
        }
        return ans;
    }

    public int dfs(int i, int delete) {
        if (i == arr.length) return Integer.MIN_VALUE / 2;
        if (memo[i][delete] != -1) return memo[i][delete];
        if (delete == 0) return memo[i][delete] = Math.max(dfs(i + 1, 0), 0) + arr[i];
        else return memo[i][delete] = Math.max(dfs(i + 1, 1) + arr[i], dfs(i + 1, 0));
    }
}