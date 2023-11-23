package LeetCode.Contest_All.单周塞.周赛348.题2;

/**
 * @author Wu
 * @date 2023年06月04日 14:56
 */
public class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int ans = 0;
        // 从头找1
        if (nums[0] != 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 1) {
                    ans += i;
                    for (int j = i; j >= 1; j--) {
                        swap(nums, j, j - 1);
                    }
                    break;
                }
            }
        }

        if (nums[nums.length - 1] != n) {
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] == n) {
                    ans += n - i - 1;
                    break;
                }
            }
        }

        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
