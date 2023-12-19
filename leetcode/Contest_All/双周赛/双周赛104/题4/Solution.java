package leetcode.Contest_All.双周赛.双周赛104.题4;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年05月13日 19:31
 */
public class Solution {
    long MOD = (long) (1e9 + 7);

    public int sumOfPower(int[] nums) {
        long ans = 0;
        Arrays.sort(nums);
        long tmp = 0;
        for (long x : nums) {
            ans += ((x * x % MOD * x % MOD) + (tmp * x * x % MOD)) % MOD;
            tmp = (tmp * 2 + x) % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

}