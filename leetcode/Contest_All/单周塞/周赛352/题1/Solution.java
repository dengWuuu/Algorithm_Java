package leetcode.Contest_All.单周塞.周赛352.题1;

/**
 * @author Wu
 * @date 2023年07月02日 13:31
 * @email dengwu.wu@foxmail.com
 */
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) continue;
            if (nums[i] > threshold) continue;
            int l = i, r = i + 1;
            while (r < nums.length) {
                if (nums[r] > threshold) break;
                if (nums[r] % 2 != nums[l] % 2) {
                    r++;
                    l++;
                }else break;
            }
            ans = Math.max(ans, r - i);

        }
        return ans;
    }
}
