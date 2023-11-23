package LeetCode.Contest_All.单周塞.周赛354.题2;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年07月16日 13:10
 */
public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[l] > k * 2) {
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }

        return ans;
    }

}