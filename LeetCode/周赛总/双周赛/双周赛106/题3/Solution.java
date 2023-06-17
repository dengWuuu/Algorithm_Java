package LeetCode.周赛总.双周赛.双周赛106.题3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {
    int MOD = (int) (1e9 + 7);

    public int sumDistance(int[] nums, String s, int d) {
        long[] end = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            end[i] = (long) nums[i] + d * (s.charAt(i) == 'R' ? 1 : -1);
        }
        long ans = 0;
        Arrays.sort(end);
        long sum = 0;
        for (int i = 0; i < end.length; i++) {
            ans = (ans + i * end[i] - sum) % MOD;
            sum += end[i];
        }
        return (int) ans;
    }
}
