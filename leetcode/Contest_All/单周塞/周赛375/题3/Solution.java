package leetcode.Contest_All.单周塞.周赛375.题3;

/**
 * @author Wu
 * @date 2023年12月12日 13:45
 */
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int max = 0;
        for (int j : nums) {
            max = Math.max(max, j);
        }
        int cnt = 0, left = 0;

        for (int num : nums) {
            if (num == max) cnt++;
            while (cnt == k) {
                if (nums[left] == max) {
                    cnt--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
