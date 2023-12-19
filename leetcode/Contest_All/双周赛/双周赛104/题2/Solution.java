package leetcode.Contest_All.双周赛.双周赛104.题2;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年05月13日 19:31
 */
public class Solution {
    public int matrixSum(int[][] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }

        for (int i = nums[0].length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(max, nums[j][i]);
            }
            cnt += max;
        }
        return cnt;
    }
}