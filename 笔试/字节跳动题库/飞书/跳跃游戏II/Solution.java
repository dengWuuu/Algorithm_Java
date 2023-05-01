package 笔试.字节跳动题库.飞书.跳跃游戏II;

/**
 * @author Wu
 * @date 2022年10月26日 15:25
 */
public class Solution {
    public int jump(int[] nums) {
        int ans = 0, end = 0, max = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;

    }
}