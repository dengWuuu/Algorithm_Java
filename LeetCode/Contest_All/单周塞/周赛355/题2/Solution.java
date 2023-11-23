package LeetCode.Contest_All.单周塞.周赛355.题2;

/**
 * @author Wu
 * @date 2023年07月23日 15:33
 */
public class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long max = nums[n -1];
        for (int i = n - 2; i >= 0; i--) {
            if (max >= nums[i]) max += nums[i];
            else max = nums[i];
        }
        return max;
    }
}