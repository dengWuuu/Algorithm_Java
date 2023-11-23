package LeetCode.Contest_All.单周塞.周赛351.题3;

/**
 * @author Wu
 * @date 2023年06月25日 20:00
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    int MOD = (int) (1e9 + 7);

    public int numberOfGoodSubarraySplits(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum == 0) return 0;
        int r = -1;
        long ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (r != -1) {
                    ans *= i - r;
                    ans %= MOD;
                }
                r = i;
            }
        }
        return (int) ans;
    }
}