package LeetCode.Contest_All.单周塞.周赛349.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年06月11日 19:31
 */
public class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length == 2 || nums.length == 1) return -1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[0] && nums[i] != nums[nums.length - 1]) return nums[i];
        }
        return -1;
    }
}