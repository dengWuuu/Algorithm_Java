package leetcode.Contest_All.双周赛.双周赛104.题3;

/**
 * @author Wu
 * @date 2023年05月13日 19:31
 */
public class Solution {
    public static long maximumOr(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        int[] cnt = new int[100];
        for (int num : nums) {
            sum |= num;
            String str = Integer.toBinaryString(num);
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) == '1') {
                    cnt[str.length() - 1 - j]++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            String str = Integer.toBinaryString(nums[i]);
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) == '1') {
                    cnt[str.length() - 1 - j]--;
                    if (cnt[str.length() - 1 - j] == 0) {
                        num += 1 << (str.length() - 1 - j);
                    }
                }
            }

            long count = sum - num;
            count |= ((long) Math.pow(2, k) * nums[i]);
            ans = Math.max(ans, count);
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) == '1') {
                    cnt[str.length() - 1 - j]++;
                }
            }

        }

        return ans;
    }
}
