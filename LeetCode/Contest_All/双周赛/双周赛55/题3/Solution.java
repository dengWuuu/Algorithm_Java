package LeetCode.Contest_All.双周赛.双周赛55.题3;

/**
 * @author Wu
 * @date 2023年12月09日 10:26
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }
        return dp[nums.length - 1][0];
    }
}