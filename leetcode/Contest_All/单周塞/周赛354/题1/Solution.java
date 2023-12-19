package leetcode.Contest_All.单周塞.周赛354.题1;

/**
 * @author Wu
 * @date 2023年07月16日 13:10
 */
public class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (n % (i + 1) == 0) {
                ans += nums[i] * nums[i];
            }
        }
        return ans;
    }
}